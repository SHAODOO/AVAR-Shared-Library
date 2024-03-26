def call(secrets) {
    def tableRows = ""
    secrets.each { secret ->
        tableRows += "<tr>"
        tableRows += "<td>${secret.Target}</td>"
        tableRows += "<td>${secret.RuleID}</td>"
        tableRows += "<td>${secret.Severity}</td>"
        tableRows += "<td>${secret.Title}</td>"
        tableRows += "<td>${secret.Line}</td>"
        tableRows += "<td>${secret.Match}</td>"
        tableRows += "</tr>"
    }
    return tableRows
}