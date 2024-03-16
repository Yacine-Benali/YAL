# PowerShell Script to build the compiler

# Change directory to the script's directory (optional, depends on your setup)
# $PSScriptRoot is the directory the script is running from
cd $PSScriptRoot

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
# Build one JAR file
jar cfm bin\yalc.jar Manifest.txt -C bin\ .

# Copy it into ./examples for demo purposes
cp bin\yalc.jar examples\yalc.jar
cp bin\yalc.jar examples2\yalc.jar



