def call(reportFile) {
    def vulnerabilities = [:]
    node {
        def jsonReport = readFile(file: reportFile)
        def json = readJSON text: jsonReport

        json.dependencies.findAll { dependency ->
            dependency.vulnerabilities
        }.each { dependency ->
            def fileName = dependency.fileName
            def dependencyVulnerabilities = dependency.vulnerabilities

            if (dependencyVulnerabilities) {
                vulnerabilities[fileName] = dependencyVulnerabilities.collect { vuln ->
                    return [name: vuln.name, severity: vuln.severity, description: vuln.description]
                }
            }
        }
    }

    return vulnerabilities
}