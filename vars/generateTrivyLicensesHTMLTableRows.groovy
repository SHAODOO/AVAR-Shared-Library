def call(licenses) {
    def tableRows = ""
    licenses.each { license ->
        tableRows += "<tr>"
        tableRows += "<td>${license.PkgName}</td>"
        tableRows += "<td>${license.Severity}</td>"
        tableRows += "<td>${license.Name}</td>"
        tableRows += "<td>${license.Confidence}</td>"
        tableRows += "</tr>"
    }
    return tableRows
}