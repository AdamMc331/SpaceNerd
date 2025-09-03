package com.adammcneilly.spacenerd.data.remote.tsd.test.mocks

val mockTsdSpaceStationListResponse = """
    {
      "count": 2,
      "next": null,
      "previous": null,
      "results": [
        $mockTsdInternationalSpaceStationSummary,
        $mockTsdTiangongSpaceStation        
      ]
    }
""".trimIndent()
