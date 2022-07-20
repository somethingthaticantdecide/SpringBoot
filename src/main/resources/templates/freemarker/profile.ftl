<#import "spring.ftl" as spring />
<link href="/css/profile.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<body>
<form style="text-align: right" method="post" action="/logout">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit"><@spring.messageText "logout" "Logout"/></button>
</form>
<#if avatar??>
    <img id="avatar" src="/images/${avatar.filename}" height="128" width="128" alt="empty profile image">
</#if>
<table id="sessions" border="1">
    <thead>
        <tr>
            <td width="200px">Data</td>
            <td width="250px">Time</td>
            <td width="200px">Ip</td>
        </tr>
    </thead>
    <#if user.sessions??>
        <#list user.sessions as session>
            <tr>
                <td>${session.date}</td>
                <td>${session.time}</td>
                <td>${session.ip}</td>
            </tr>
        </#list>
    </#if>
</table>

<form id="upload" method="POST" action="uploadAvatar" enctype="multipart/form-data" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    File:<input type="file" name="file" id="file"/>
    <br/>
    <input type="submit" value="Upload" name="upload"/>
</form>

<table id="images" border="1">
    <thead>
        <tr>
            <td width="450px">File name</td>
            <td width="150px">Size</td>
            <td width="150px">MIME</td>
        </tr>
    </thead>
    <#if user.avatars??>
        <#list user.avatars as image>
            <tr>
                <td><a href="images/${image.filename}">${image.filename}</a></td>
                <td>${image.size}</td>
                <td>${image.mime}</td>
            </tr>
        </#list>
    </#if>
</table>
</body>
</html>
