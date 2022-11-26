// def call() {
//     node {
//         sh 'rm -rf *'
//         git branch: 'main', url: "https://github.com/b50-clouddevops/${COMPONENT}.git"
//         common.sonarCheck()
//         common.lintCheck()
//         env.ARGS="-Dsonar.sources=."
//         common.testCases()
//         if (env.TAG_NAME != null) {
//             common.artifact()
//         }
//     }
// }

def call() {
    node {
        sh 'rm -rf *'
        git branch: 'main', url: "https://github.com/b50-clouddevops/${COMPONENT}.git"

        stage('Docker Image Build') {
            sh "docker build -t 355449129696.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:latest"
            sh "docker images"
        }

        stage('Docker Push') {
            sh "docker build ."
            sh "docker images"
        }
    }
}