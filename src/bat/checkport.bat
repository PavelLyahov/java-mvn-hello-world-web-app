@echo off

if "x%1x" == "xx" goto displayUsage
set numberPort=%1
rem unusedPort flag to verify if PID was exploiter of required Port.
set "unusedPort="
rem lastPID avoid repeat PID
set "lastPID="
rem netstat -nao | find /i ":8081 " | find /i "LISTENING"
for /f "delims=" %%s in ('netstat -nao ^| find /i ":%numberPort% " ^| find /i "LISTENING"') do (
  rem Separate Connections using required port
  rem   TCP    0.0.0.0:80             0.0.0.0:0              LISTENING       1960
  for /f "tokens=2" %%# in ("%%s") do (
    rem Separate Local Address
    rem 0.0.0.0:80
    echo.%%# | findstr /C:":%numberPort% " 1> nul
    if not ERRORLEVEL 1 (
      for /f "tokens=5" %%p in ("%%s") do (
        rem Separate PID
        rem 1960
        rem tasklist /fi "pid eq %%p"
        set "unusedPort=false"
        rem if not defined lastPID (
        rem if not "%%p"=="%lastPID%" (
        if not defined lastPID (
          set "lastPID=%%p"
          2>nul Wmic service where "ProcessId like '%%p'" get Name, PathName, ProcessId, State| findstr /i "Name"> nul
          if ERRORLEVEL 1 (
            rem echo %%p is a process using the Port %numberPort%!
            for /f "skip=3 delims=1" %%i in ('tasklist /fi "pid eq %%p"') do (
              for /f "tokens=1" %%n in ("%%i") do (
                echo The %numberPort% port is being used with PID %%p by %%n process:
              )
            )
            Wmic process where "ProcessId like '%%p'" get Name
          ) else (
            for /f "skip=3 delims=1" %%i in ('tasklist /fi "pid eq %%p"') do (
              for /f "tokens=1" %%n in ("%%i") do (
                echo The %numberPort% port is being used with PID %%p by %%n service:
              )
            )
            rem echo %%p is a service using the Port %numberPort%!
            Wmic service where "ProcessId like '%%p'" get Name, PathName, State
          )
        )
      )
    )
  )
)

netstat -nao | find /i ":%numberPort% "> nul
if ERRORLEVEL 1 (
  echo The %numberPort% port is not being used in Local Address.
) else (
  if not defined unusedPort (
    echo The %numberPort% port is not being used in Local Address.
  )
)
goto :end

:displayUsage
echo.
echo Usage: %~n0.bat [port]


:end

timeout /t 2