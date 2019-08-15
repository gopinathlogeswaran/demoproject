pipeline {
    agent any
    stages {
        stage('checkout'){
            steps{
               git 'https://github.com/gopinathlogeswaran/demoproject.git' 
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
                 publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'Integration Test Report', reportTitles: ''])

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
