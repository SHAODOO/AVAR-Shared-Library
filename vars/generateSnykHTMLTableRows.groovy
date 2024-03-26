def call(snykVulnerabilities) {
    def tableRows = ""
    snykVulnerabilities.each { vulnerability ->
        tableRows += "<tr>"
        tableRows += "<td>${vulnerability.ruleId}</td>"
        tableRows += "<td>${vulnerability.level}</td>"
        tableRows += "<td>${vulnerability.message}</td>"
        tableRows += "<td>${vulnerability.artifactUri}</td>"
        tableRows += "<td>Ln ${vulnerability.startLine}, Col ${vulnerability.startColumn} - Ln ${vulnerability.endLine}, Col ${vulnerability.endColumn}</td>"
        tableRows += "</tr>"
    }
    return tableRows
}