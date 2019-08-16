pipeline {
    agent any
    parameters {
      string defaultValue: 'https://github.com/gopinathlogeswaran/demoproject.git',description: 'Enter the Source Code URL:', name: 'GIT_URL', trim: true
    }
    environment{
        BUILD_ID="dontKillMe"
    }
    stages {
        stage('checkout'){
            steps{
                deleteDir()
               git GIT_URL 
            }
        }
        
        stage('build'){
            steps{
                sh '''
                ./gradlew clean build -x test
                '''
                }
        }
        stage('quality check'){
        parallel{
        stage('unit tests'){
            steps{
              sh '''
                ./gradlew test
                '''
                 publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Test Report', reportTitles: ''])

            }
            }
        stage('checkstyle'){
            steps{
                echo "Parallel stage"
            }
        }
        }
        }
        
            
            stage('deploy into dev'){
            steps{
              //input message: 'Approve to dev', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
              echo 'yet to implement'


            }
            }
             stage('integration tests'){
            steps{
              sh '''
                ./gradlew test
                '''
                 publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Dev Integration Test Report', reportTitles: ''])

            }
        }

        stage('deploy into QA'){
            steps{
              //input message: 'Approve to QA', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
              echo 'yet to implement'

            }
            }

        stage('qa integration tests '){
            steps{
              sh '''
                ./gradlew test
                '''
                 publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'QA Integration Test Report', reportTitles: ''])
            input message: 'Approve to Prod', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
            }
        }
        stage('CD'){
        parallel{
        stage('deploy into Prod'){
            steps{
              echo 'yet to implement'
              sh '''
              cd build/libs/ 
              set +e
              java -jar *.jar
              '''
            }
            }
        stage('smoke tests'){
            steps{
                sh '''
                sleep 90
                curl --silent --retry-delay 10 --retry 5 http://localhost:8090/location/name/tcs-bangalore -o ${WORKSPACE}/info.json
                if [ $(grep -i tcs-bangalore@tcs.com info.json | wc -l) -eq 1 ]
                then
                echo "Smoke Test Success"
                else
                echo "Smoke Test Failed!!"
                fi
                # Stop application
                curl -X POST http://localhost:8090/actuator/shutdown
                '''
            }
        }
        }
        }
    }
    post {
    unstable {
    // One or more steps need to be included within each condition's block.
    slackSend color: 'danger', iconEmoji: '', message: 'Build failed', username: ''
    }
    failure {
      slackSend color: 'danger', iconEmoji: '', message: 'Build failed', username: ''
    // One or more steps need to be included within each condition's block.
    }
    }
    }
def deploymentOk(){
    def workspacePath = pwd()
    expectedCommitid = new File("${workspacePath}/expectedCommitid.txt").text.trim()
    actualCommitid = readCommitidFromJson()
    println "expected commitid from txt: ${expectedCommitid}"
    println "actual commitid from json: ${actualCommitid}"
    return expectedCommitid == actualCommitid
}