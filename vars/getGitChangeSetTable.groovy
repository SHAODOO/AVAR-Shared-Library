def call(repositoryUrl) {
    def changelogTable = ""
    def build = currentBuild

    if (build.changeSets.size() > 0) {
        changelogTable += build.changeSets.collect { cs ->
            cs.collect { entry ->
                def formattedTimestamp = new Date(entry.timestamp.toLong()).toString()
                def id = entry.commitId
                def files = entry.affectedFiles.collect { file ->
                    file.path
                }.join(", ")
                def author = entry.author.fullName
                def message = entry.msg
                def commitUrl = "${repositoryUrl}/commit/${id}"
                "<tr><td><a href=\"${commitUrl}\">${id}</a></td><td>${author}</td><td>${message}</td><td>${files}</td><td>${formattedTimestamp}</td></tr>"
            }.join('\n')
        }.join('\n')
    } else {
        def buildsWithChangeset = 0
        while (buildsWithChangeset < 5 && build != null) {
            if (build.changeSets.size() > 0) {
                changelogTable += build.changeSets.collect { cs ->
                    cs.collect { entry ->
                        def formattedTimestamp = new Date(entry.timestamp.toLong()).toString()
                        def id = entry.commitId
                        def files = entry.affectedFiles.collect { file ->
                            file.path
                        }.join(", ")
                        def author = entry.author.fullName
                        def message = entry.msg
                        // Construct GitHub commit URL
                        def commitUrl = "${repositoryUrl}/commit/${id}"
                        "<tr><td><a href=\"${commitUrl}\">${id}</a></td><td>${author}</td><td>${message}</td><td>${files}</td><td>${formattedTimestamp}</td></tr>"
                    }.join('\n')
                }.join('\n')
                buildsWithChangeset++
            }
            build = build.previousBuild
        }
    }

    if (changelogTable.isEmpty()) {
        changelogTable = "<tr><td colspan=\"5\">No changesets found</td></tr>"
    }

    return changelogTable
}
