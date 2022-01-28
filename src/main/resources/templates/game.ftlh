<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>The Mauritian Adventure</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body style="text-align: center">
<h1>Mauritian Adventure</h1>
<div>Player Health: ${gameState.getPlayer().getLife()}</div>
<div>

    ${gameState.getPlayer().getDescription()}

</div>

<div>
    <#noautoesc>
        ${mainText}
    </#noautoesc>
</div>
<#list actions as action>

    <button type="button" class="btn btn-default" onclick="window.location.href='/action/${action.getActionUrl()}'"
            style="margin: 5px">${action.getActionLabel()}</button>
    <br>
</#list>
<div>
    <img src="/images/${location.getImage()}"
         style="width: 100%; filter: brightness(${gameState.getCurrentDayTime().getBrightness()}%)">
</div>
</body>
</html>