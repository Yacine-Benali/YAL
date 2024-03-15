# PowerShell Script to process grammar with JJTree and JavaCC, compile Java files, and run a Java program

# Change directory to the script's directory (optional, depends on your setup)
# $PSScriptRoot is the directory the script is running from
# cd $PSScriptRoot

if (Test-Path ./examples/graph.dot) {
    Remove-Item ./examples/graph.dot
} else {
    Write-Host "File ./examples/graph.dot does not exist."
}

if (Test-Path ./examples/graph.png) {
    Remove-Item ./examples/graph.png
} else {
    Write-Host "File ./examples/graph.png does not exist."
}

# Run JJTree
jjtree src\main\mygrammar.jjt
if ($LASTEXITCODE -ne 0) {
    Write-Error "JJTree failed with exit code $LASTEXITCODE"
    exit $LASTEXITCODE
}

# Run JavaCC
javacc -OUTPUT_DIRECTORY:src\main\jjtree src\main\jjtree\mygrammar.jj
if ($LASTEXITCODE -ne 0) {
    Write-Error "JavaCC failed with exit code $LASTEXITCODE"
    exit $LASTEXITCODE
}

# Get list of all Java files
$files = Get-ChildItem -Recurse -Filter *.java | Where-Object { -not $_.PSIsContainer } | Select-Object -ExpandProperty FullName

# Join file paths into a single string
$filesAsString = $files -join ' '

# Compile the Java files
Invoke-Expression "javac $filesAsString -d ./bin"
if ($LASTEXITCODE -ne 0) {
    Write-Error "Java compilation failed with exit code $LASTEXITCODE"
    exit $LASTEXITCODE
}

# Run the Java program
java -cp ./bin main.jjtree.MyGrammar ./examples/sem_func.txt
if ($LASTEXITCODE -ne 0) {
    Write-Error "Java execution failed with exit code $LASTEXITCODE"
    exit $LASTEXITCODE
}

# if AST exists visualize it
dot -Tpng ./examples/graph.dot -o ./examples/graph.png