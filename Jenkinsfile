pipeline {
   agent any

   environment {
        TOMCAT_PATH = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javaweb'
    }

   stages {
       stage('Unit tests') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Build war') {
            steps {
                echo "build war file"
                bat 'mvn package'
            }
        }
        stage('Rename war') {
            steps {
                bat """
                call cd target
                call dir
                call rename mvn-hello-world.war ROOT.war
                """
            }
        }
        stage('Delete old war file and clear appfolder') {
            steps {
                bat """
                cd /d ${TOMCAT_PATH}
                dir
                IF EXIST "*.war" for /F "delims=" %%i in ('dir /b') do (rmdir "%%i" /s/q || del "%%i" /s/q)
                """
            }
        }
        stage('Copy war') {
            steps {
                bat """
                cd target
                dir
                copy ROOT.war "${TOMCAT_PATH}"
                """
            }
        }
        stage('Restart tomcat') {
            steps {
                bat """
                echo "Redirect is not supported"
                """
            }
        }
        stage('Build info') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
            }
        }
   }

   post {
       always {
           echo 'Clearing workspace'
           cleanWs()
       }
   }

}
