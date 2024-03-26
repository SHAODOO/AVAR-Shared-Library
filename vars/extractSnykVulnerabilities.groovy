def call(reportFile) {
    def vulnerabilities = []
    def jsonReport = readFile(file: reportFile)
    def json = readJSON text: jsonReport
    
    json.runs.each { run ->
        run.results.each { result ->
            def vulnerability = [:]
            vulnerability['ruleId'] = result.ruleId
            vulnerability['level'] = result.level
            vulnerability['message'] = result.message.text
            vulnerability['artifactUri'] = result.locations[0].physicalLocation.artifactLocation.uri
            vulnerability['startLine'] = result.locations[0].physicalLocation.region.startLine
            vulnerability['endLine'] = result.locations[0].physicalLocation.region.endLine
            vulnerability['startColumn'] = result.locations[0].physicalLocation.region.startColumn
            vulnerability['endColumn'] = result.locations[0].physicalLocation.region.endColumn
            vulnerabilities.add(vulnerability)
        }
    }
    
    return vulnerabilities
}