<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1..5</h1>
<#list (1..5) as i>
    ${i}<br>
</#list>
<br>-----------------<br>
<h1>5..1</h1>
<#list (5..1) as i>
    ${i}<br>
</#list>
<br>-----------------<br>
<h1>1..<5</h1>
<#list (1..<5) as i>
    ${i}<br>
</#list>
<br>-----------------<br>
<h1>5..<1</h1>
<#list (5..<1) as i>
    ${i}<br>
</#list>
<br>-----------------<br>
<h1>2..*5</h1>
<#list (1..*5) as i>
    ${i}<br>
</#list>
<br>-----------------<br>
</body>
</html>