def call(reportFile) {
    def jsonReport = readFile(file: reportFile)
    def json = readJSON text: jsonReport
    def vulnerabilities = []

    json.Results.each { result ->
        if (result.Vulnerabilities) { 
            result.Vulnerabilities.each { vulnerability ->
                def vuln = [
                    Target: result.Target,
                    VulnerabilityID: "<a href=\"${vulnerability.PrimaryURL}\">${vulnerability.VulnerabilityID}</a>",
                    Severity: vulnerability.Severity,
                    Title: vulnerability.Title,
                    Description: vulnerability.Description,
                    PkgName: vulnerability.PkgName,
                    InstalledVersion: vulnerability.InstalledVersion,
                    FixedVersion: vulnerability.FixedVersion
                ]
                vulnerabilities.add(vuln)
            }
        }
    }
    return vulnerabilities
}