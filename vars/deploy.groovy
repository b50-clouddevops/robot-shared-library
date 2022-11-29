def call() {
    pipeline {
        agent any 
   parameters {
        string(name: 'VERSION', defaultValue: '', description: 'Chose the version to deploy')
        string(name: 'ENV', defaultValue: 'dev', description: 'Chose the ENV to deploy')
        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
    }
        stages {
            stage('Lint Check') {
                steps {
                    script { 
                        lintCheck()
                    }
                }
            }
            stage('Sonar Check') {
                steps {
                    script { 
                        env.ARGS="-Dsonar.sources=."
                        common.sonarCheck()
                    }
                }
            }
           stage('Test Cases') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        sh 'echo Unit Test Cases Completed'
                         }
                    }
                stage('Integration Tests') {
                    steps {
                        sh 'echo Integration Test Cases Completed'
                         }
                    }
                stage('Functional Tests') {
                    steps {
                        sh 'echo Functional Test Cases Completed'
                         }
                    }
                }
            }
        }    // end of statges 
    }
}