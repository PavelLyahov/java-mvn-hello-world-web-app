pipeline {
  agent any

  stages {
    stage('Build') {
        steps {
            bat """
                call cd C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javawebhelloworld
                call del /F /S /Q *.* for
                call for /d %%x in (.\\*) do @rd /s /q %%x
            """
            echo "build war file"
            bat 'mvn package'
        }
    }
  }
}