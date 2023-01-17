pipeline {
  agent any

  stages {
    stage('Build') {
        steps {
            echo "clear workspase"
            bat 'dir'
            bat 'cd C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javawebhelloworld'
            bat 'dir'
            bat 'del /F /S /Q *.*'
            bat 'for /d %%x in (.\\*) do @rd /s /q %%x'
            echo "build war file"
            bat 'mvn package'
            bat 'dir'
        }
    }
  }
}