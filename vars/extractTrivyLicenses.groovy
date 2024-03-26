def call(reportFile) {
    def jsonReport = readFile(file: reportFile)
    def json = readJSON text: jsonReport
    def licenses = []

    json.Results.each { result ->
        if (result.Licenses) { // Check if the result is a license
            result.Licenses.each { license ->
                def lic = [
                    PkgName: license.PkgName,
                    Severity: license.Severity,
                    Name: license.Name,
                    Confidence: license.Confidence,
                ]
                licenses.add(lic)
            }
        }
    }
    return licenses
}