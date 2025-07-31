@echo off
echo =========================================
echo  Simple Hotel Booking System
echo =========================================
echo.
echo Starting application...
echo.

REM Check Java
java -version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Java not found
    echo Please install Java 11 or higher
    pause
    exit /b 1
)

REM Compile if needed
if not exist "build\HotelBookingApp.class" (
    echo Compiling...
    mkdir build 2>nul
    javac -d build src\HotelBookingApp.java
    if errorlevel 1 (
        echo ERROR: Compilation failed
        pause
        exit /b 1
    )
)

REM Run application
echo Launching Hotel Booking System...
java -cp build HotelBookingApp

echo.
echo Application closed.
pause 