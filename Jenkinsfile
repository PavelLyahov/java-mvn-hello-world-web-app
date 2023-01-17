pipeline {
  agent any

  stages {
    stage('Build') {
        steps {
            echo "clear workspase"
            bat 'cd C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javawebhelloworld del /F /S /Q *.* for /d %%x in (.\\*) do @rd /s /q %%x'
            echo "build war file"
            bat 'mvn package'
        }
    }
  }
}