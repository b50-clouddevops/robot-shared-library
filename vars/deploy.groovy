def call() {
    pipeline {
        agent any 
   parameters {
        string(name: 'VERSION', defaultValue: '', description: 'Chose the version to deploy')
        string(name: 'ENV', defaultValue: 'dev', description: 'Chose the ENV to deploy')
    }
        stages {
            stage('Deploying Component') {
                steps {
                    sh "echo Authenticating to $ENV EKS"
                    
                }
            }


        }    // end of statges 
    }
}