# PowerShell Script to process grammar with JJTree and JavaCC, compile Java files, and run the compiler


# First argument: file path
param (
    [string]$FilePath
)

# Change directory to the script's directory (optional, depends on your setup)
# $PSScriptRoot is the directory the script is running from
cd $PSScriptRoot



# Get the directory of the file
$directory = [System.IO.Path]::GetDirectoryName($filePath)

# Name of the graph files to check for
$graphFile1 = "graph.dot"
$graphFile2= "graph.png"

# Construct the full path of the graph files
$graph1FilePath = [System.IO.Path]::Combine($directory, $graphFile1)
$graph2FilePath = [System.IO.Path]::Combine($directory, $graphFile2)



if (Test-Path $graph1FilePath) {
    Remove-Item $graph1FilePath
} else {
    Write-Host "The file $graph1FilePath does not exists in the same folder."
}

if (Test-Path $graph2FilePath) {
    Remove-Item $graph2FilePath
} else {
    Write-Host "The file $graph2FilePath does not exists in the same folder."
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
java -cp ./bin main.jjtree.MyGrammar $FilePath
if ($LASTEXITCODE -ne 0) {
    Write-Error "Java execution failed with exit code $LASTEXITCODE"
    exit $LASTEXITCODE
}

# if AST exists visualize it
try {
    # check if dot is installed
    & dot --version > null
    $installed = $true
} catch {
    # If an error occurs, it likely means the command is not installed
    $installed = $false
}

# render the png
if ($installed) {
    dot -Tpng $graph1FilePath -o $graph2FilePath
}