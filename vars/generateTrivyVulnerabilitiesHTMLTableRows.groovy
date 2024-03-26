def call(trivyVulnerabilities) {
    def tableRows = ""
    trivyVulnerabilities.each { vulnerability ->
        tableRows += "<tr>"
        tableRows += "<td>${vulnerability.Target}</td>"
        tableRows += "<td>${vulnerability.VulnerabilityID}</td>"
        tableRows += "<td>${vulnerability.Severity}</td>"
        tableRows += "<td>${vulnerability.Title}</td>"
        tableRows += "<td>${vulnerability.Description}</td>"
        tableRows += "<td>${vulnerability.PkgName}</td>"
        tableRows += "<td>${vulnerability.InstalledVersion}</td>"
        tableRows += "<td>${vulnerability.FixedVersion}</td>"
        tableRows += "</tr>"
    }
    return tableRows
}
