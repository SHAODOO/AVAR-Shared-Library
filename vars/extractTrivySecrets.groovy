def call(reportFile) {
    def jsonReport = readFile(file: reportFile)
    def json = readJSON text: jsonReport
    def secrets = []

    json.Results.each { result ->
        if (result.Secrets) { 
            result.Secrets.each { secret ->
                def sec = [
                    Target: result.Target,
                    RuleID: secret.RuleID,
                    Severity: secret.Severity,
                    Title: secret.Title,
                    Line: secret.StartLine,
                    Match: secret.Match
                ]
                secrets.add(sec)
            }
        }
    }
    return secrets
}