pipeline {
   agent any

   environment {
   TOKEN = credentials('jenkins_token_access')
        TOMCAT_PATH = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\javaweb'
    }

   stages {
       stage('Unit Test___ffddve_de') {
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
         stage('Trigger test job') {
                   steps {
                       bat("curl -u %TOKEN_USR%:%TOKEN_PSW% https://admin:1129c48191b9df691e6deef8e4c34893cc@8bc7-188-169-82-252.eu.ngrok.io/job/JavaWebTest/build?token=tokenForTestinJob123321")
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
