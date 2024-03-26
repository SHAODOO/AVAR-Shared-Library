def call(OWASPVulnerabilities) {
    def tableRows = ""
    OWASPVulnerabilities.each { fileName, vulns ->        
        vulns.eachWithIndex { vuln, index ->
            if (index > 0) {
                tableRows += "<tr>"
            }
            tableRows += "<td>${fileName}</td>"
            tableRows += "<td>${vuln.name}</td>"
            tableRows += "<td>${vuln.severity}</td>"
            tableRows += "<td>${vuln.description}</td>"
            tableRows += "</tr>"
        }
    }
    return tableRows
}