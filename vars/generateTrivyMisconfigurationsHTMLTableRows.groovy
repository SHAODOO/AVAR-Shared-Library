def call(trivyMisconfigurations) {
    def tableRows = ""
    trivyMisconfigurations.each { misconfiguration ->
        tableRows += "<tr>"
        tableRows += "<td>${misconfiguration.Target}</td>"
        tableRows += "<td>${misconfiguration.AVDID}</td>"
        tableRows += "<td>${misconfiguration.Title}</td>"
        tableRows += "<td>${misconfiguration.Description}</td>"
        tableRows += "<td>${misconfiguration.Resolution}</td>"
        tableRows += "</tr>"
    }
    return tableRows
}