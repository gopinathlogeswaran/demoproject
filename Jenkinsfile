pipeline {
    agent any
    parameters {
      string default: 'https://github.com/gopinathlogeswaran/demoproject.git',description: 'Enter the Source Code URL:', name: 'GIT_URL', trim: true
    }
    stages {
        stage('checkout'){
            steps{
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
              input message: 'Approve to dev', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
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
              input message: 'Approve to QA', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
              echo 'yet to implement'

            }
            }

        stage('qa integration tests '){
            steps{
              sh '''
                ./gradlew test
                '''
                 publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'QA Integration Test Report', reportTitles: ''])

            }
        }
        stage('deploy into Prod'){
            steps{
              input message: 'Approve to Prod', parameters: [string(defaultValue: '', description: 'Please enter the change reference no', name: 'Change No', trim: false)], submitter: 'demouser'
              echo 'yet to implement'
              sh 'nohup java -jar /build/libs/*.jar &'

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