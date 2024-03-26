def call(reportFile) {
    def jsonReport = readFile(file: reportFile)
    def json = readJSON text: jsonReport
    def misconfigurations = []

    json.Results.each { result ->
        if (result.Misconfigurations) { 
            result.Misconfigurations.each { misconfiguration ->
                def misconf = [
                    Target: result.Target,
                    AVDID: "<a href=\"${misconfiguration.PrimaryURL}\">${misconfiguration.AVDID}</a>",
                    Title: misconfiguration.Title,
                    Description: misconfiguration.Description,
                    Resolution: misconfiguration.Resolution,
                ]
                misconfigurations.add(misconf)
            }
        }
    }
    return misconfigurations
}