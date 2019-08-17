pipelineJob('demopipeline') {

	parameters {
        stringParam('GIT_URL', 'https://github.com/gopinathlogeswaran/demoproject.git', 'Enter the Source Code URL:')
    }
    
    definition {
        cps {
            script(readFileFromWorkspace('my-new-dsl.groovy'))
            sandbox()
        }
    }
}