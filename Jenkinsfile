pipeline {
    agent any

    triggers {

    parameterizedCron('''
                0 21 * * * %SUITE_NAME=SmokeTest.xml
                30 21 * * * %SUITE_NAME=RegressionTest.xml
            ''')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
     string(name: 'SUITE_NAME', defaultValue: 'SmokeTest.xml')
     choice(choices: ['Chrome', 'Firefox'], description: 'Select a browser', name: 'BROWSER')
     booleanParam (defaultValue: false, description: 'HeadLess', name: 'HEADLESS')
    }

    stages {
        stage('Run Selenium Tests') {
            steps {
                // Get some code from a GitHub repository
                // On Windows should be %{params.BRANCH}%
                git branch: "${params.BRANCH}", url: 'https://github.com/EvgeniyAbramovich/SauceDemo_QA22_AbramovichEvgeniy'

                // Run Maven on an agent.
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }
    }


}