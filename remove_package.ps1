Get-ChildItem -Path 'core-java-practice' -Recurse -Filter '*.java' | ForEach-Object {
    $content = Get-Content $_.FullName
    if ($content[0] -match '^package\s+.*;$') {
        $newContent = $content | Select-Object -Skip 1
        Set-Content $_.FullName $newContent
    }
}
