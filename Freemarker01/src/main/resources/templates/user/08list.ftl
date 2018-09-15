<html>
<head>
    <title>Title</title>
</head>
<body>
<#list ["1", 2, "3", true?c] as x>
    ${x}<br>
</#list>
<br>-----------------------------<br>
<#list ['1', 2] + ["3", true?c] as user>
    ${user}<br>
</#list>
<br>-----------------------------<br>
<#assign  seq = ["A", "B", "C", "D", "E"]>
<#list seq[1..3] as i>
    ${i}
</#list>

</body>
</html>