@echo off 

set directorio=%cd%
set segundos=3

cd %directorio%
:loop
git pull
git add --all
git commit -m "autoCommit %date:~-4%%date:~3,2%%date:~0,2%.%time:~0,2%%time:~3,2%%time:~6,2%"
git push
timeout /t %segundos% /nobreak
goto :loop