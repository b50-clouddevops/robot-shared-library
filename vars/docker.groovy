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
        
        stage('Docker Build') {
            sh "docker build ."
            sh "docker images"
        }
    }
}