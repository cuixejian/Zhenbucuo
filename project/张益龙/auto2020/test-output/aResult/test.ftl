<!DOCTYPE html>
<html>
<body>
<table border="1">
    <tr>
        <th>name</th>
        <th>email</th>
    </tr>
    <!-- 遍历输出-->
    <#list tests as Test1>
        <tr>
            <th>${Test1.name}</th>
        </tr>
    </#list>
</table>
</body>