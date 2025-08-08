package com.adammcneilly.spacenerd.data.remote.tsd.test.mocks

val mockTsdLaunchListResponse = """
    {
      "count": 7572,
      "next": "https://ll.thespacedevs.com/2.3.0/launches/?limit=2&offset=2",
      "previous": null,
      "results": [
        {
          "id": "e3df2ecd-c239-472f-95e4-2b89b4f75800",
          "url": "https://ll.thespacedevs.com/2.3.0/launches/e3df2ecd-c239-472f-95e4-2b89b4f75800/",
          "name": "Sputnik 8K74PS | Sputnik 1",
          "response_mode": "normal",
          "slug": "sputnik-8k74ps-sputnik-1",
          "launch_designator": "1957-001",
          "status": {
            "id": 3,
            "name": "Launch Successful",
            "abbrev": "Success",
            "description": "The launch vehicle successfully inserted its payload(s) into the target orbit(s)."
          },
          "last_updated": "2024-03-17T19:17:35Z",
          "net": "1957-10-04T19:28:34Z",
          "net_precision": null,
          "window_end": "1957-10-04T19:28:34Z",
          "window_start": "1957-10-04T19:28:34Z",
          "image": {
            "id": 1844,
            "name": "[AUTO] Sputnik 8K74PS - image",
            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193923.jpeg",
            "credit": null,
            "license": {
              "id": 1,
              "name": "Unknown",
              "priority": 9,
              "link": null
            },
            "single_use": true,
            "variants": []
          },
          "infographic": null,
          "probability": null,
          "weather_concerns": null,
          "failreason": "",
          "hashtag": null,
          "launch_service_provider": {
            "response_mode": "list",
            "id": 66,
            "url": "https://ll.thespacedevs.com/2.3.0/agencies/66/",
            "name": "Soviet Space Program",
            "abbrev": "CCCP",
            "type": {
              "id": 1,
              "name": "Government"
            }
          },
          "rocket": {
            "id": 3003,
            "configuration": {
              "response_mode": "list",
              "id": 468,
              "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/468/",
              "name": "Sputnik 8K74PS",
              "families": [
                {
                  "response_mode": "list",
                  "id": 154,
                  "name": "Sputnik"
                }
              ],
              "full_name": "Sputnik 8K74PS",
              "variant": "8K74PS"
            }
          },
          "mission": {
            "id": 1430,
            "name": "Sputnik 1",
            "type": "Test Flight",
            "description": "First artificial satellite consisting of a 58 cm pressurized aluminium shell containing two 1 W transmitters for a total mass of 83.6 kg.",
            "image": null,
            "orbit": {
              "id": 8,
              "name": "Low Earth Orbit",
              "abbrev": "LEO",
              "celestial_body": {
                "response_mode": "list",
                "id": 1,
                "name": "Earth"
              }
            },
            "agencies": [],
            "info_urls": [],
            "vid_urls": []
          },
          "pad": {
            "id": 32,
            "url": "https://ll.thespacedevs.com/2.3.0/pads/32/",
            "active": true,
            "agencies": [],
            "name": "1/5",
            "image": null,
            "description": null,
            "info_url": null,
            "wiki_url": "",
            "map_url": "https://www.google.com/maps?q=45.92,63.342",
            "latitude": 45.92,
            "longitude": 63.342,
            "country": {
              "id": 44,
              "name": "Kazakhstan",
              "alpha_2_code": "KZ",
              "alpha_3_code": "KAZ",
              "nationality_name": "Kazakh",
              "nationality_name_composed": "Kazakhstani"
            },
            "map_image": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/map_images/pad_32_20200803143513.jpg",
            "total_launch_count": 487,
            "orbital_launch_attempt_count": 487,
            "fastest_turnaround": "PT23H32M33S",
            "location": {
              "response_mode": "normal",
              "id": 15,
              "url": "https://ll.thespacedevs.com/2.3.0/locations/15/",
              "name": "Baikonur Cosmodrome, Republic of Kazakhstan",
              "celestial_body": {
                "response_mode": "normal",
                "id": 1,
                "name": "Earth",
                "type": {
                  "id": 1,
                  "name": "Planet"
                },
                "diameter": 12742000,
                "mass": 5.972168e+24,
                "gravity": 9.80655,
                "length_of_day": "1 00:00:00",
                "atmosphere": true,
                "image": {
                  "id": 2040,
                  "name": "Earth (Apollo 17)",
                  "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/earth_2528apol_image_20240402194304.jpeg",
                  "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/earth_2528apol_image_thumbnail_20240402194305.jpeg",
                  "credit": "NASA",
                  "license": {
                    "id": 4,
                    "name": "NASA Image and Media Guidelines",
                    "priority": 0,
                    "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
                  },
                  "single_use": true,
                  "variants": []
                },
                "description": "Earth is the third planet from the Sun and the only astronomical object known to harbor life.",
                "wiki_url": "https://en.wikipedia.org/wiki/Earth",
                "total_attempted_launches": 7232,
                "successful_launches": 6686,
                "failed_launches": 546,
                "total_attempted_landings": 1159,
                "successful_landings": 1114,
                "failed_landings": 45
              },
              "active": true,
              "country": {
                "id": 44,
                "name": "Kazakhstan",
                "alpha_2_code": "KZ",
                "alpha_3_code": "KAZ",
                "nationality_name": "Kazakh",
                "nationality_name_composed": "Kazakhstani"
              },
              "description": "The Baikonur Cosmodrome is a spaceport operated by Russia within Kazakhstan. Located in the Kazakh city of Baikonur, it is the largest operational space launch facility in terms of area. All Russian crewed spaceflights are launched from Baikonur.",
              "image": {
                "id": 2198,
                "name": "Soyuz launch pad at the Baikonur Cosmodrome",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/soyuz_launch_pa_image_20240918150530.jpg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/soyuz_launch_pa_image_thumbnail_20240918150530.jpeg",
                "credit": "NASA/Bill Ingalls",
                "license": {
                  "id": 4,
                  "name": "NASA Image and Media Guidelines",
                  "priority": 0,
                  "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
                },
                "single_use": true,
                "variants": []
              },
              "map_image": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/map_images/location_15_20200803142517.jpg",
              "longitude": 63.305,
              "latitude": 45.965,
              "timezone_name": "Asia/Qyzylorda",
              "total_launch_count": 1556,
              "total_landing_count": 0
            }
          },
          "webcast_live": false,
          "program": [],
          "orbital_launch_attempt_count": 1,
          "location_launch_attempt_count": 1,
          "pad_launch_attempt_count": 1,
          "agency_launch_attempt_count": 1,
          "orbital_launch_attempt_count_year": 1,
          "location_launch_attempt_count_year": 1,
          "pad_launch_attempt_count_year": 1,
          "agency_launch_attempt_count_year": 1
        },
        {
          "id": "f8c9f344-a6df-4f30-873a-90fe3a7840b3",
          "url": "https://ll.thespacedevs.com/2.3.0/launches/f8c9f344-a6df-4f30-873a-90fe3a7840b3/",
          "name": "Sputnik 8K74PS | Sputnik 2",
          "response_mode": "normal",
          "slug": "sputnik-8k74ps-sputnik-2",
          "launch_designator": "1957-002",
          "status": {
            "id": 3,
            "name": "Launch Successful",
            "abbrev": "Success",
            "description": "The launch vehicle successfully inserted its payload(s) into the target orbit(s)."
          },
          "last_updated": "2023-06-14T03:48:36Z",
          "net": "1957-11-03T02:30:00Z",
          "net_precision": null,
          "window_end": "1957-11-03T02:30:00Z",
          "window_start": "1957-11-03T02:30:00Z",
          "image": {
            "id": 1844,
            "name": "[AUTO] Sputnik 8K74PS - image",
            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sputnik_8k74ps_image_20210830185541.jpg",
            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193923.jpeg",
            "credit": null,
            "license": {
              "id": 1,
              "name": "Unknown",
              "priority": 9,
              "link": null
            },
            "single_use": true,
            "variants": []
          },
          "infographic": null,
          "probability": null,
          "weather_concerns": null,
          "failreason": null,
          "hashtag": null,
          "launch_service_provider": {
            "response_mode": "list",
            "id": 66,
            "url": "https://ll.thespacedevs.com/2.3.0/agencies/66/",
            "name": "Soviet Space Program",
            "abbrev": "CCCP",
            "type": {
              "id": 1,
              "name": "Government"
            }
          },
          "rocket": {
            "id": 3004,
            "configuration": {
              "response_mode": "list",
              "id": 468,
              "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/468/",
              "name": "Sputnik 8K74PS",
              "families": [
                {
                  "response_mode": "list",
                  "id": 154,
                  "name": "Sputnik"
                }
              ],
              "full_name": "Sputnik 8K74PS",
              "variant": "8K74PS"
            }
          },
          "mission": {
            "id": 1431,
            "name": "Sputnik 2",
            "type": "Test Flight",
            "description": "Second artificial satellite and first to carry an animal into orbit.",
            "image": null,
            "orbit": {
              "id": 8,
              "name": "Low Earth Orbit",
              "abbrev": "LEO",
              "celestial_body": {
                "response_mode": "list",
                "id": 1,
                "name": "Earth"
              }
            },
            "agencies": [],
            "info_urls": [],
            "vid_urls": []
          },
          "pad": {
            "id": 32,
            "url": "https://ll.thespacedevs.com/2.3.0/pads/32/",
            "active": true,
            "agencies": [],
            "name": "1/5",
            "image": null,
            "description": null,
            "info_url": null,
            "wiki_url": "",
            "map_url": "https://www.google.com/maps?q=45.92,63.342",
            "latitude": 45.92,
            "longitude": 63.342,
            "country": {
              "id": 44,
              "name": "Kazakhstan",
              "alpha_2_code": "KZ",
              "alpha_3_code": "KAZ",
              "nationality_name": "Kazakh",
              "nationality_name_composed": "Kazakhstani"
            },
            "map_image": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/map_images/pad_32_20200803143513.jpg",
            "total_launch_count": 487,
            "orbital_launch_attempt_count": 487,
            "fastest_turnaround": "PT23H32M33S",
            "location": {
              "response_mode": "normal",
              "id": 15,
              "url": "https://ll.thespacedevs.com/2.3.0/locations/15/",
              "name": "Baikonur Cosmodrome, Republic of Kazakhstan",
              "celestial_body": {
                "response_mode": "normal",
                "id": 1,
                "name": "Earth",
                "type": {
                  "id": 1,
                  "name": "Planet"
                },
                "diameter": 12742000,
                "mass": 5.972168e+24,
                "gravity": 9.80655,
                "length_of_day": "1 00:00:00",
                "atmosphere": true,
                "image": {
                  "id": 2040,
                  "name": "Earth (Apollo 17)",
                  "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/earth_2528apol_image_20240402194304.jpeg",
                  "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/earth_2528apol_image_thumbnail_20240402194305.jpeg",
                  "credit": "NASA",
                  "license": {
                    "id": 4,
                    "name": "NASA Image and Media Guidelines",
                    "priority": 0,
                    "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
                  },
                  "single_use": true,
                  "variants": []
                },
                "description": "Earth is the third planet from the Sun and the only astronomical object known to harbor life.",
                "wiki_url": "https://en.wikipedia.org/wiki/Earth",
                "total_attempted_launches": 7232,
                "successful_launches": 6686,
                "failed_launches": 546,
                "total_attempted_landings": 1159,
                "successful_landings": 1114,
                "failed_landings": 45
              },
              "active": true,
              "country": {
                "id": 44,
                "name": "Kazakhstan",
                "alpha_2_code": "KZ",
                "alpha_3_code": "KAZ",
                "nationality_name": "Kazakh",
                "nationality_name_composed": "Kazakhstani"
              },
              "description": "The Baikonur Cosmodrome is a spaceport operated by Russia within Kazakhstan. Located in the Kazakh city of Baikonur, it is the largest operational space launch facility in terms of area. All Russian crewed spaceflights are launched from Baikonur.",
              "image": {
                "id": 2198,
                "name": "Soyuz launch pad at the Baikonur Cosmodrome",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/soyuz_launch_pa_image_20240918150530.jpg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/soyuz_launch_pa_image_thumbnail_20240918150530.jpeg",
                "credit": "NASA/Bill Ingalls",
                "license": {
                  "id": 4,
                  "name": "NASA Image and Media Guidelines",
                  "priority": 0,
                  "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
                },
                "single_use": true,
                "variants": []
              },
              "map_image": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/map_images/location_15_20200803142517.jpg",
              "longitude": 63.305,
              "latitude": 45.965,
              "timezone_name": "Asia/Qyzylorda",
              "total_launch_count": 1556,
              "total_landing_count": 0
            }
          },
          "webcast_live": false,
          "program": [],
          "orbital_launch_attempt_count": 2,
          "location_launch_attempt_count": 2,
          "pad_launch_attempt_count": 2,
          "agency_launch_attempt_count": 2,
          "orbital_launch_attempt_count_year": 2,
          "location_launch_attempt_count_year": 2,
          "pad_launch_attempt_count_year": 2,
          "agency_launch_attempt_count_year": 2
        }
      ]
    }
""".trimIndent()
