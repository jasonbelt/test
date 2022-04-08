::#! 2> /dev/null                                   #
@ 2>/dev/null # 2>nul & echo off & goto BOF         #
if [ -z ${SIREUM_HOME} ]; then                      #
  echo "Please set SIREUM_HOME env var"             #
  exit -1                                           #
fi                                                  #
exec ${SIREUM_HOME}/bin/sireum slang run "$0" "$@"  #
:BOF
setlocal
if not defined SIREUM_HOME (
  echo Please set SIREUM_HOME env var
  exit /B -1
)
%SIREUM_HOME%\bin\sireum.bat slang run "%0" %*
exit /B %errorlevel%
::!#
// #Sireum

import org.sireum._
import org.sireum.project.ProjectUtil._
import org.sireum.project.{Project, ProjectUtil}

val homeDir = Os.slashDir.up.canon

var mod = moduleJvmPub(
  id = "id",
  baseDir = homeDir,
  jvmDeps = ISZ(),
  jvmIvyDeps = ISZ(),
  pubOpt = None()
)

val project = Project.empty + mod

projectCli(Os.cliArgs, project)
