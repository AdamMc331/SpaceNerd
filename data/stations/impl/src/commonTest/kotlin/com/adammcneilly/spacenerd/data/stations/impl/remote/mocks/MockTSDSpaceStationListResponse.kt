package com.adammcneilly.spacenerd.data.stations.impl.remote.mocks

val mockTsdSpaceStationListResponse = """
    {
      "count": 2,
      "next": null,
      "previous": null,
      "results": [
        {
          "id": 4,
          "url": "https://ll.thespacedevs.com/2.3.0/space_stations/4/",
          "name": "International Space Station",
          "image": {
            "id": 1952,
            "name": "ISS as seen from Shuttle Atlantis (STS-132)",
            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/international2520space2520station_image_20190220215716.jpeg",
            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194230.jpeg",
            "credit": "NASA",
            "license": {
              "id": 4,
              "name": "NASA Image and Media Guidelines",
              "priority": 0,
              "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
            },
            "single_use": false,
            "variants": []
          },
          "status": {
            "id": 1,
            "name": "Active"
          },
          "founded": "1998-11-20",
          "deorbited": null,
          "description": "The International Space Station (ISS) is a space station, or a habitable artificial satellite, in low Earth orbit. Its first component was launched into orbit in 1998, with the first long-term residents arriving in November 2000. It has been inhabited continuously since that date. The last pressurised module was fitted in 2011, and an experimental inflatable space habitat was added in 2016. The station is expected to operate until 2030. Development and assembly of the station continues, with several new elements scheduled for launch in 2019. The ISS is the largest human-made body in low Earth orbit and can often be seen with the naked eye from Earth. The ISS consists of pressurised habitation modules, structural trusses, solar arrays, radiators, docking ports, experiment bays and robotic arms. ISS components have been launched by Russian Proton and Soyuz rockets, and American Space Shuttles.",
          "orbit": "Low Earth Orbit",
          "type": {
            "id": 2,
            "name": "Government"
          },
          "owners": [
            {
              "response_mode": "normal",
              "id": 16,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/16/",
              "name": "Canadian Space Agency",
              "abbrev": "CSA",
              "type": {
                "id": 1,
                "name": "Government"
              },
              "featured": false,
              "country": [
                {
                  "id": 26,
                  "name": "Canada",
                  "alpha_2_code": "CA",
                  "alpha_3_code": "CAN",
                  "nationality_name": "Canadian",
                  "nationality_name_composed": "Canado"
                }
              ],
              "description": "The Canadian Space Agency was established by the Canadian Space Agency Act which received Royal Assent on May 10, 1990. \r\n\r\nThe Canadian space program is administered by the Canadian Space Agency. Canada has contributed technology, expertise and personnel to the world space effort, especially in collaboration with ESA and NASA. In addition to its astronauts and satellites, some of the most notable Canadian technological contributions to space exploration include the Canadarm on the Space Shuttle and Canadarm2 on the International Space Station.",
              "administrator": "President: Lisa Campbell",
              "founding_year": 1990,
              "launchers": "",
              "spacecraft": "",
              "parent": null,
              "image": null,
              "logo": {
                "id": 120,
                "name": "[AUTO] Canadian Space Agency - logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/canadian2520space2520agency_logo_20231122160211.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184927.png",
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
              "social_logo": {
                "id": 47,
                "name": "[AUTO] Canadian Space Agency - social_logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/canadian2520space2520agency_nation_20231122160211.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184741.png",
                "credit": null,
                "license": {
                  "id": 1,
                  "name": "Unknown",
                  "priority": 9,
                  "link": null
                },
                "single_use": true,
                "variants": []
              }
            },
            {
              "response_mode": "normal",
              "id": 27,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/27/",
              "name": "European Space Agency",
              "abbrev": "ESA",
              "type": {
                "id": 2,
                "name": "Multinational"
              },
              "featured": false,
              "country": [
                {
                  "id": 1,
                  "name": "France",
                  "alpha_2_code": "FR",
                  "alpha_3_code": "FRA",
                  "nationality_name": "French",
                  "nationality_name_composed": "Franco"
                },
                {
                  "id": 3,
                  "name": "Italy",
                  "alpha_2_code": "IT",
                  "alpha_3_code": "ITA",
                  "nationality_name": "Italian",
                  "nationality_name_composed": "Italo"
                },
                {
                  "id": 4,
                  "name": "Germany",
                  "alpha_2_code": "DE",
                  "alpha_3_code": "DEU",
                  "nationality_name": "German",
                  "nationality_name_composed": "Germano"
                },
                {
                  "id": 7,
                  "name": "Spain",
                  "alpha_2_code": "ES",
                  "alpha_3_code": "ESP",
                  "nationality_name": "Spanish",
                  "nationality_name_composed": "Hispano"
                },
                {
                  "id": 8,
                  "name": "Switzerland",
                  "alpha_2_code": "CH",
                  "alpha_3_code": "CHE",
                  "nationality_name": "Swiss",
                  "nationality_name_composed": "Swiss"
                },
                {
                  "id": 10,
                  "name": "United Kingdom",
                  "alpha_2_code": "GB",
                  "alpha_3_code": "GBR",
                  "nationality_name": "British",
                  "nationality_name_composed": "Brito"
                },
                {
                  "id": 11,
                  "name": "Austria",
                  "alpha_2_code": "AT",
                  "alpha_3_code": "AUT",
                  "nationality_name": "Austrian",
                  "nationality_name_composed": "Austro"
                },
                {
                  "id": 15,
                  "name": "Sweden",
                  "alpha_2_code": "SE",
                  "alpha_3_code": "SWE",
                  "nationality_name": "Swedish",
                  "nationality_name_composed": "Swedo"
                },
                {
                  "id": 23,
                  "name": "Portugal",
                  "alpha_2_code": "PT",
                  "alpha_3_code": "PRT",
                  "nationality_name": "Portuguese",
                  "nationality_name_composed": "Luso"
                },
                {
                  "id": 27,
                  "name": "Netherlands",
                  "alpha_2_code": "NL",
                  "alpha_3_code": "NLD",
                  "nationality_name": "Dutch",
                  "nationality_name_composed": "Dutch"
                },
                {
                  "id": 31,
                  "name": "Hungary",
                  "alpha_2_code": "HU",
                  "alpha_3_code": "HUN",
                  "nationality_name": "Hungarian",
                  "nationality_name_composed": "Hungarian"
                },
                {
                  "id": 39,
                  "name": "Poland",
                  "alpha_2_code": "PL",
                  "alpha_3_code": "POL",
                  "nationality_name": "Polish",
                  "nationality_name_composed": "Polono"
                },
                {
                  "id": 45,
                  "name": "Denmark",
                  "alpha_2_code": "DK",
                  "alpha_3_code": "DNK",
                  "nationality_name": "Danish",
                  "nationality_name_composed": "Dano"
                },
                {
                  "id": 46,
                  "name": "Czechia",
                  "alpha_2_code": "CZ",
                  "alpha_3_code": "CZE",
                  "nationality_name": "Czech",
                  "nationality_name_composed": "Czech"
                },
                {
                  "id": 47,
                  "name": "Romania",
                  "alpha_2_code": "RO",
                  "alpha_3_code": "ROU",
                  "nationality_name": "Romanian",
                  "nationality_name_composed": "Romanian"
                },
                {
                  "id": 49,
                  "name": "Norway",
                  "alpha_2_code": "NO",
                  "alpha_3_code": "NOR",
                  "nationality_name": "Norwegian",
                  "nationality_name_composed": "Norwegian"
                },
                {
                  "id": 77,
                  "name": "Finland",
                  "alpha_2_code": "FI",
                  "alpha_3_code": "FIN",
                  "nationality_name": "Finnish",
                  "nationality_name_composed": "Finno"
                },
                {
                  "id": 78,
                  "name": "Greece",
                  "alpha_2_code": "GR",
                  "alpha_3_code": "GRC",
                  "nationality_name": "Greek",
                  "nationality_name_composed": "Greco"
                },
                {
                  "id": 80,
                  "name": "Estonia",
                  "alpha_2_code": "EE",
                  "alpha_3_code": "EST",
                  "nationality_name": "Estonian",
                  "nationality_name_composed": "Estonian"
                },
                {
                  "id": 81,
                  "name": "Ireland",
                  "alpha_2_code": "IE",
                  "alpha_3_code": "IRL",
                  "nationality_name": "Irish",
                  "nationality_name_composed": "Irish"
                },
                {
                  "id": 85,
                  "name": "Luxembourg",
                  "alpha_2_code": "LU",
                  "alpha_3_code": "LUX",
                  "nationality_name": "Luxembourger",
                  "nationality_name_composed": "Luxembourgish"
                },
                {
                  "id": 20,
                  "name": "Belgium",
                  "alpha_2_code": "BE",
                  "alpha_3_code": "BEL",
                  "nationality_name": "Belgian",
                  "nationality_name_composed": "Belgo"
                },
                {
                  "id": 86,
                  "name": "Slovenia",
                  "alpha_2_code": "SI",
                  "alpha_3_code": "SVN",
                  "nationality_name": "Slovenian",
                  "nationality_name_composed": "Slovenian"
                }
              ],
              "description": "The European Space Agency is an intergovernmental organisation of 22 member states. Established in 1975 and headquartered in Paris, France, ESA has a worldwide staff of about 2,000 employees.\r\n\r\nESA's space flight programme includes human spaceflight (mainly through participation in the International Space Station program); the launch and operation of unmanned exploration missions to other planets and the Moon; Earth observation, science and telecommunication; designing launch vehicles; and maintaining a major spaceport, the Guiana Space Centre at Kourou, French Guiana.",
              "administrator": "Director General: Josef Aschbacher",
              "founding_year": 1975,
              "launchers": "Ariane | Vega",
              "spacecraft": "Space Rider",
              "parent": null,
              "image": {
                "id": 2324,
                "name": "ESA patch floating in the ISS Cupola",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/esa_patch_float_image_20250211192109.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/esa_patch_float_image_thumbnail_20250211192110.png",
                "credit": "ESA",
                "license": {
                  "id": 2,
                  "name": "ESA Standard Licence",
                  "priority": 2,
                  "link": "https://www.esa.int/ESA_Multimedia/Terms_and_conditions_of_use_of_images_and_videos_available_on_the_esa_website"
                },
                "single_use": false,
                "variants": []
              },
              "logo": {
                "id": 130,
                "name": "European Space Agency logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/european2520space2520agency_logo_20221130101442.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184947.png",
                "credit": "ESA",
                "license": {
                  "id": 2,
                  "name": "ESA Standard Licence",
                  "priority": 2,
                  "link": "https://www.esa.int/ESA_Multimedia/Terms_and_conditions_of_use_of_images_and_videos_available_on_the_esa_website"
                },
                "single_use": true,
                "variants": []
              },
              "social_logo": {
                "id": 130,
                "name": "European Space Agency logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/european2520space2520agency_logo_20221130101442.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184947.png",
                "credit": "ESA",
                "license": {
                  "id": 2,
                  "name": "ESA Standard Licence",
                  "priority": 2,
                  "link": "https://www.esa.int/ESA_Multimedia/Terms_and_conditions_of_use_of_images_and_videos_available_on_the_esa_website"
                },
                "single_use": true,
                "variants": []
              }
            },
            {
              "response_mode": "normal",
              "id": 37,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/37/",
              "name": "Japan Aerospace Exploration Agency",
              "abbrev": "JAXA",
              "type": {
                "id": 1,
                "name": "Government"
              },
              "featured": true,
              "country": [
                {
                  "id": 28,
                  "name": "Japan",
                  "alpha_2_code": "JP",
                  "alpha_3_code": "JPN",
                  "nationality_name": "Japanese",
                  "nationality_name_composed": "Nippo"
                }
              ],
              "description": "The Japan Aerospace Exploration Agency (JAXA) is Japan's national aero-space agency. Through the merger of three previously independent organizations, JAXA was formed on 1 October 2003. JAXA is responsible for research, technology development and the launch of satellites into orbit, and is involved in many more advanced missions, such as asteroid exploration and possible manned exploration of the Moon. JAXA launch their Epsilon vehicle from the Uchinoura Space Center and their H-II vehicles from the Tanegashima Space Center.",
              "administrator": "Administrator: Hiroshi Yamakawa",
              "founding_year": 2003,
              "launchers": "H-II",
              "spacecraft": "",
              "parent": null,
              "image": {
                "id": 16,
                "name": "[AUTO] Japan Aerospace Exploration Agency - image",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/japan2520aerospace2520exploration2520agency_image_20190207032440.jpeg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184621.jpeg",
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
              "logo": {
                "id": 151,
                "name": "[AUTO] Japan Aerospace Exploration Agency - logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/japan2520aerospace2520exploration2520agency_logo_20190207032440.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305185023.png",
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
              "social_logo": {
                "id": 69,
                "name": "[AUTO] Japan Aerospace Exploration Agency - social_logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/japan2520aerospace2520exploration2520agency_nation_20230531052930.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184813.png",
                "credit": null,
                "license": {
                  "id": 1,
                  "name": "Unknown",
                  "priority": 9,
                  "link": null
                },
                "single_use": true,
                "variants": []
              }
            },
            {
              "response_mode": "normal",
              "id": 44,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
              "name": "National Aeronautics and Space Administration",
              "abbrev": "NASA",
              "type": {
                "id": 1,
                "name": "Government"
              },
              "featured": true,
              "country": [
                {
                  "id": 2,
                  "name": "United States of America",
                  "alpha_2_code": "US",
                  "alpha_3_code": "USA",
                  "nationality_name": "American",
                  "nationality_name_composed": "Americano"
                }
              ],
              "description": "The National Aeronautics and Space Administration is an independent agency of the executive branch of the United States federal government responsible for the civilian space program, as well as aeronautics and aerospace research. NASA have many launch facilities but most are inactive. The most commonly used pad will be LC-39B at Kennedy Space Center in Florida.",
              "administrator": "Acting Administrator:  James Free",
              "founding_year": 1958,
              "launchers": "Space Shuttle | SLS",
              "spacecraft": "Orion",
              "parent": null,
              "image": {
                "id": 19,
                "name": "[AUTO] National Aeronautics and Space Administration - image",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/national2520aeronautics2520and2520space2520administration_image_20190207032448.jpeg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184631.jpeg",
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
              "logo": {
                "id": 161,
                "name": "[AUTO] National Aeronautics and Space Administration - logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/national2520aeronautics2520and2520space2520administration_logo_20190207032448.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305185043.png",
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
              "social_logo": {
                "id": 76,
                "name": "[AUTO] National Aeronautics and Space Administration - social_logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/national2520aeronautics2520and2520space2520administration_nation_20230803040809.jpg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184823.jpeg",
                "credit": null,
                "license": {
                  "id": 1,
                  "name": "Unknown",
                  "priority": 9,
                  "link": null
                },
                "single_use": true,
                "variants": []
              }
            },
            {
              "response_mode": "normal",
              "id": 63,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/63/",
              "name": "Russian Federal Space Agency (ROSCOSMOS)",
              "abbrev": "RFSA",
              "type": {
                "id": 1,
                "name": "Government"
              },
              "featured": true,
              "country": [
                {
                  "id": 5,
                  "name": "Russia",
                  "alpha_2_code": "RU",
                  "alpha_3_code": "RUS",
                  "nationality_name": "Russian",
                  "nationality_name_composed": "Russo"
                }
              ],
              "description": "The Roscosmos State Corporation for Space Activities, commonly known as Roscosmos, is the governmental body responsible for the space science program of the Russian Federation and general aerospace research. Soyuz has many launch locations the Russian sites are Baikonur, Plesetsk and Vostochny however Ariane also purchases the vehicle and launches it from French Guiana.",
              "administrator": "Administrator: Yuri Borisov",
              "founding_year": 1992,
              "launchers": "Soyuz",
              "spacecraft": "Soyuz",
              "parent": null,
              "image": {
                "id": 25,
                "name": "[AUTO] Russian Federal Space Agency (ROSCOSMOS) - image",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/russian2520federal2520space2520agency25202528roscosmos2529_image_20190207032459.jpeg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184652.jpeg",
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
              "logo": {
                "id": 177,
                "name": "[AUTO] Russian Federal Space Agency (ROSCOSMOS) - logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/russian2520federal2520space2520agency25202528roscosmos2529_logo_20190207032459.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305185118.png",
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
              "social_logo": {
                "id": 89,
                "name": "[AUTO] Russian Federal Space Agency (ROSCOSMOS) - social_logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/russian2520federal2520space2520agency25202528roscosmos2529_nation_20230531052758.jpg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184841.jpeg",
                "credit": null,
                "license": {
                  "id": 1,
                  "name": "Unknown",
                  "priority": 9,
                  "link": null
                },
                "single_use": true,
                "variants": []
              }
            }
          ],
          "response_mode": "normal",
          "active_expeditions": [
            {
              "id": 162,
              "url": "https://ll.thespacedevs.com/2.3.0/expeditions/162/",
              "name": "Expedition 73",
              "start": "2025-04-19T21:57:33Z",
              "end": null
            }
          ]
        },
        {
          "id": 18,
          "url": "https://ll.thespacedevs.com/2.3.0/space_stations/18/",
          "name": "Tiangong space station",
          "image": {
            "id": 1941,
            "name": "[AUTO] Tiangong space station - image",
            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/tiangong_space__image_20231031004146.png",
            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194211.png",
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
          "status": {
            "id": 1,
            "name": "Active"
          },
          "founded": "2021-04-29",
          "deorbited": null,
          "description": "The Tiangong space station is a space station placed in Low Earth orbit between 340 and 450 km above the surface. It will be roughly one-fifth the mass of the International Space Station and about the size of the Mir space station.",
          "orbit": "Low Earth Orbit",
          "type": {
            "id": 2,
            "name": "Government"
          },
          "owners": [
            {
              "response_mode": "normal",
              "id": 88,
              "url": "https://ll.thespacedevs.com/2.3.0/agencies/88/",
              "name": "China Aerospace Science and Technology Corporation",
              "abbrev": "CASC",
              "type": {
                "id": 1,
                "name": "Government"
              },
              "featured": true,
              "country": [
                {
                  "id": 6,
                  "name": "China",
                  "alpha_2_code": "CN",
                  "alpha_3_code": "CHN",
                  "nationality_name": "Chinese",
                  "nationality_name_composed": "Sino"
                }
              ],
              "description": "The China Aerospace Science and Technology Corporation (CASC) is the main contractor for the Chinese space program. It is state-owned and has a number of subordinate entities which design, develop and manufacture a range of spacecraft, launch vehicles, strategic and tactical missile systems, and ground equipment. It was officially established in July 1999 as part of a Chinese government reform drive, having previously been one part of the former China Aerospace Corporation. Various incarnations of the program date back to 1956.",
              "administrator": "Chairman & President: Lei Fanpei",
              "founding_year": 1999,
              "launchers": "Long March",
              "spacecraft": "",
              "parent": null,
              "image": {
                "id": 8,
                "name": "[AUTO] China Aerospace Science and Technology Corporation - image",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/china2520aerospace2520science2520and2520technology2520corporation_image_20191228094408.jpeg",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184558.jpeg",
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
              "logo": {
                "id": 124,
                "name": "[AUTO] China Aerospace Science and Technology Corporation - logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/china2520aerospace2520science2520and2520technology2520corporation_logo_20220826093937.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184933.png",
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
              "social_logo": {
                "id": 50,
                "name": "[AUTO] China Aerospace Science and Technology Corporation - social_logo",
                "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/china2520aerospace2520science2520and2520technology2520corporation_nation_20230604193716.png",
                "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184746.png",
                "credit": null,
                "license": {
                  "id": 1,
                  "name": "Unknown",
                  "priority": 9,
                  "link": null
                },
                "single_use": true,
                "variants": []
              }
            }
          ],
          "response_mode": "normal",
          "active_expeditions": [
            {
              "id": 163,
              "url": "https://ll.thespacedevs.com/2.3.0/expeditions/163/",
              "name": "Shenzhou 20",
              "start": "2025-04-24T15:49:00Z",
              "end": null
            }
          ]
        }
      ]
    }
""".trimIndent()
