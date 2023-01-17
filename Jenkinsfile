pipeline {
  agent any

  stages {
    stage('Build') {
        steps {
            bat """
                call cd C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javawebhelloworld
                call del /F /S /Q *.*
            """
            echo "build war file"
            bat 'mvn package'
        }
    }
  }
}