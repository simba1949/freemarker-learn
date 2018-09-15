<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<#-- if 指令-->
<#if  !users??>
users 不为 null
<#elseif common.username == '杜甫' >
users 为 null，且 common.username == '杜甫'
<#else>
users 不为 null,且 common.username != '杜甫'
</#if>

</html>