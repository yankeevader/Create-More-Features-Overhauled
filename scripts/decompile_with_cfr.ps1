param(
    [Parameter(Mandatory=$true)]
    [string]$JarPath,

    [string]$CfrJar = ".\cfr-0.152.jar",

    [string]$OutputDir = ".\cfr-output"
)

if (!(Test-Path $JarPath)) {
    throw "Jar not found: $JarPath"
}

if (!(Test-Path $CfrJar)) {
    throw "CFR jar not found: $CfrJar"
}

New-Item -ItemType Directory -Force -Path $OutputDir | Out-Null
java -jar $CfrJar $JarPath --outputdir $OutputDir --caseinsensitivefs true
