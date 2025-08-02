package com.adammcneilly.spacenerd.data.remote.tsd.test.mocks

val mockTsdAgencyResponse = """
    {
        "response_mode": "detailed",
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
        },
        "total_launch_count": 141,
        "consecutive_successful_launches": 11,
        "successful_launches": 121,
        "failed_launches": 20,
        "pending_launches": 6,
        "consecutive_successful_landings": 0,
        "successful_landings": 0,
        "failed_landings": 0,
        "attempted_landings": 0,
        "successful_landings_spacecraft": 178,
        "failed_landings_spacecraft": 2,
        "attempted_landings_spacecraft": 180,
        "successful_landings_payload": 0,
        "failed_landings_payload": 0,
        "attempted_landings_payload": 0,
        "info_url": "https://www.nasa.gov",
        "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
        "social_media_links": [],
        "launcher_list": [
            {
                "response_mode": "detailed",
                "id": 126,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/126/",
                "name": "Ares I-X",
                "families": [],
                "full_name": "Ares I-X",
                "variant": "I-X",
                "active": false,
                "is_placeholder": false,
                "program": [],
                "reusable": false,
                "image": {
                    "id": 1685,
                    "name": "[AUTO] Ares I-X - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/ares2520i-x_image_20190222030444.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193502.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Ares_I",
                "description": "Ares I was the crew launch vehicle that was being developed by NASA as part of the Constellation program. Ares I-X was a design concept demonstrator, that had a dummy second stage and a partially functional first stage.",
                "alias": "",
                "min_stage": 1,
                "max_stage": 1,
                "length": 99.7,
                "diameter": 3.71,
                "maiden_flight": "2009-10-28",
                "launch_cost": null,
                "launch_mass": 816.0,
                "leo_capacity": null,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 12000.0,
                "apogee": null,
                "total_launch_count": 1,
                "consecutive_successful_launches": 1,
                "successful_launches": 1,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 162,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/162/",
                "name": "Atlas LV-3B",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 66,
                        "name": "Atlas",
                        "manufacturer": [
                            {
                                "response_mode": "normal",
                                "id": 82,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/82/",
                                "name": "Lockheed Martin",
                                "abbrev": "LMT",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
                                },
                                "featured": false,
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
                                "description": "Lockheed Martin's Space Division started in the production of missiles and later ICBM's in the 1950s. Their TITAN missile system was used for 12 Gemini spacecraft and the Voyager probes.  They have worked largely in collaboration with NASA on many of their probes, landers, and spacecraft, and hope to play a key role in NASA's return to the moon in 2024.",
                                "administrator": null,
                                "founding_year": 1953,
                                "launchers": "Titan | Agena",
                                "spacecraft": "Hubble | JUNO | InSight",
                                "parent": null,
                                "image": null,
                                "logo": null,
                                "social_logo": null,
                                "total_launch_count": 80,
                                "consecutive_successful_launches": 38,
                                "successful_launches": 77,
                                "failed_launches": 3,
                                "pending_launches": 0,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.lockheedmartin.com/",
                                "wiki_url": "https://en.wikipedia.org/wiki/Lockheed_Martin",
                                "social_media_links": []
                            },
                            {
                                "response_mode": "normal",
                                "id": 124,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/124/",
                                "name": "United Launch Alliance",
                                "abbrev": "ULA",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
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
                                "description": "United Launch Alliance (ULA) is a joint venture of Lockheed Martin Space Systems and Boeing Defense, Space & Security. ULA was formed in December 2006 by combining the teams at these companies which provide spacecraft launch services to the government of the United States. ULA launches from both coasts of the US. They launch their Atlas V vehicle from LC-41 in Cape Canaveral and LC-3E at Vandeberg. Their Delta IV launches from LC-37 at Cape Canaveral and LC-6 at Vandenberg.",
                                "administrator": "CEO: Tory Bruno",
                                "founding_year": 2006,
                                "launchers": "Atlas | Delta IV | Vulcan",
                                "spacecraft": "CST-100 Starliner",
                                "parent": null,
                                "image": {
                                    "id": 30,
                                    "name": "[AUTO] United Launch Alliance - image",
                                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united_launch_a_image_20210412201210.png",
                                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184706.png",
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
                                    "id": 191,
                                    "name": "[AUTO] United Launch Alliance - logo",
                                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united2520launch2520alliance_logo_20210412195953.png",
                                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305185148.png",
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
                                    "id": 97,
                                    "name": "[AUTO] United Launch Alliance - social_logo",
                                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united2520launch2520alliance_nation_20230531043703.jpg",
                                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184852.jpeg",
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
                                "total_launch_count": 166,
                                "consecutive_successful_launches": 166,
                                "successful_launches": 166,
                                "failed_launches": 0,
                                "pending_launches": 42,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.ulalaunch.com/",
                                "wiki_url": "https://en.wikipedia.org/wiki/United_Launch_Alliance",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": true,
                        "maiden_flight": "1958-12-18",
                        "total_launch_count": 437,
                        "consecutive_successful_launches": 179,
                        "successful_launches": 400,
                        "failed_launches": 37,
                        "pending_launches": 13,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    },
                    {
                        "response_mode": "detailed",
                        "id": 188,
                        "name": "Atlas D",
                        "manufacturer": [
                            {
                                "response_mode": "normal",
                                "id": 1004,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/1004/",
                                "name": "Convair",
                                "abbrev": "",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
                                },
                                "featured": false,
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
                                "description": "Convair, previously Consolidated Vultee, was an American aircraft manufacturing company that later expanded into rockets and spacecraft. The company was formed in 1943 by the merger of Consolidated Aircraft and Vultee Aircraft. In 1953 it was purchased by General Dynamics, and operated as their Convair Division for most of its corporate history.",
                                "administrator": null,
                                "founding_year": 1943,
                                "launchers": "",
                                "spacecraft": "",
                                "parent": null,
                                "image": null,
                                "logo": null,
                                "social_logo": null,
                                "total_launch_count": 1,
                                "consecutive_successful_launches": 1,
                                "successful_launches": 1,
                                "failed_launches": 0,
                                "pending_launches": 0,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": null,
                                "wiki_url": "https://en.wikipedia.org/wiki/Convair",
                                "social_media_links": []
                            }
                        ],
                        "parent": {
                            "response_mode": "normal",
                            "id": 66,
                            "name": "Atlas",
                            "manufacturer": [
                                {
                                    "response_mode": "normal",
                                    "id": 82,
                                    "url": "https://ll.thespacedevs.com/2.3.0/agencies/82/",
                                    "name": "Lockheed Martin",
                                    "abbrev": "LMT",
                                    "type": {
                                        "id": 3,
                                        "name": "Commercial"
                                    },
                                    "featured": false,
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
                                    "description": "Lockheed Martin's Space Division started in the production of missiles and later ICBM's in the 1950s. Their TITAN missile system was used for 12 Gemini spacecraft and the Voyager probes.  They have worked largely in collaboration with NASA on many of their probes, landers, and spacecraft, and hope to play a key role in NASA's return to the moon in 2024.",
                                    "administrator": null,
                                    "founding_year": 1953,
                                    "launchers": "Titan | Agena",
                                    "spacecraft": "Hubble | JUNO | InSight",
                                    "parent": null,
                                    "image": null,
                                    "logo": null,
                                    "social_logo": null
                                },
                                {
                                    "response_mode": "normal",
                                    "id": 124,
                                    "url": "https://ll.thespacedevs.com/2.3.0/agencies/124/",
                                    "name": "United Launch Alliance",
                                    "abbrev": "ULA",
                                    "type": {
                                        "id": 3,
                                        "name": "Commercial"
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
                                    "description": "United Launch Alliance (ULA) is a joint venture of Lockheed Martin Space Systems and Boeing Defense, Space & Security. ULA was formed in December 2006 by combining the teams at these companies which provide spacecraft launch services to the government of the United States. ULA launches from both coasts of the US. They launch their Atlas V vehicle from LC-41 in Cape Canaveral and LC-3E at Vandeberg. Their Delta IV launches from LC-37 at Cape Canaveral and LC-6 at Vandenberg.",
                                    "administrator": "CEO: Tory Bruno",
                                    "founding_year": 2006,
                                    "launchers": "Atlas | Delta IV | Vulcan",
                                    "spacecraft": "CST-100 Starliner",
                                    "parent": null,
                                    "image": {
                                        "id": 30,
                                        "name": "[AUTO] United Launch Alliance - image",
                                        "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united_launch_a_image_20210412201210.png",
                                        "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184706.png",
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
                                        "id": 191,
                                        "name": "[AUTO] United Launch Alliance - logo",
                                        "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united2520launch2520alliance_logo_20210412195953.png",
                                        "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305185148.png",
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
                                        "id": 97,
                                        "name": "[AUTO] United Launch Alliance - social_logo",
                                        "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/united2520launch2520alliance_nation_20230531043703.jpg",
                                        "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305184852.jpeg",
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
                            "parent": null
                        },
                        "description": "",
                        "active": false,
                        "maiden_flight": "1959-09-09",
                        "total_launch_count": 133,
                        "consecutive_successful_launches": 21,
                        "successful_launches": 118,
                        "failed_launches": 15,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Atlas LV-3B",
                "variant": "LV-3B",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 2,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/2/",
                        "name": "Mercury",
                        "image": {
                            "id": 1880,
                            "name": "[AUTO] Mercury - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/project2520mer_program_20200820194755.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194025.png",
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
                        "info_url": "https://www.nasa.gov/mission_pages/mercury/missions/program-toc.html",
                        "wiki_url": "https://en.wikipedia.org/wiki/Project_Mercury",
                        "description": "Project Mercury was the first human spaceflight program of the United States, running from 1958 through 1963.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "1958-10-07T00:00:00Z",
                        "end_date": "1963-05-16T23:24:02Z",
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1696,
                    "name": "[AUTO] Atlas LV-3B - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/atlas_image_20190222030015.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193522.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Atlas_LV-3B",
                "description": "The Atlas LV-3B, Atlas D Mercury Launch Vehicle or Mercury-Atlas Launch Vehicle, was a human-rated expendable launch system used as part of the United States Project Mercury to send astronauts into low Earth orbit. Manufactured by American aircraft manufacturing company Convair, it was derived from the SM-65D Atlas missile, and was a member of the Atlas family of rockets.",
                "alias": "",
                "min_stage": 1,
                "max_stage": 1,
                "length": 28.7,
                "diameter": 3.0,
                "maiden_flight": "1960-07-29",
                "launch_cost": null,
                "launch_mass": 120.0,
                "leo_capacity": 1360.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 1300.0,
                "apogee": null,
                "total_launch_count": 10,
                "consecutive_successful_launches": 6,
                "successful_launches": 7,
                "failed_launches": 3,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P63DT2H5M"
            },
            {
                "response_mode": "detailed",
                "id": 342,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/342/",
                "name": "Nike Cajun",
                "families": [],
                "full_name": "Nike Cajun",
                "variant": "",
                "active": false,
                "is_placeholder": false,
                "program": [],
                "reusable": false,
                "image": null,
                "info_url": "",
                "wiki_url": "https://en.wikipedia.org/wiki/Nike-Cajun",
                "description": "The Nike-Cajun was a two-stage sounding rocket built by combining a Nike base stage with a Cajun upper stage. It was launched 714 times between 1956 and 1976 and was the most frequently used sounding rocket of the western world.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 7.7,
                "diameter": 0.42,
                "maiden_flight": "1956-07-06",
                "launch_cost": null,
                "launch_mass": 0.0,
                "leo_capacity": null,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 246.0,
                "apogee": null,
                "total_launch_count": 4,
                "consecutive_successful_launches": 4,
                "successful_launches": 4,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P178DT4H12M"
            },
            {
                "response_mode": "detailed",
                "id": 195,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/195/",
                "name": "Orion Abort Test Booster",
                "families": [],
                "full_name": "Orion Abort Test Booster",
                "variant": "",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 15,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/15/",
                        "name": "Artemis",
                        "image": {
                            "id": 1884,
                            "name": "[AUTO] Artemis - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/artemis_program_20220827100930.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194033.png",
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
                        "info_url": "https://www.nasa.gov/specials/artemis/",
                        "wiki_url": "https://en.wikipedia.org/wiki/Artemis_program",
                        "description": "The Artemis program is a US government-funded crewed spaceflight program that has the goal of landing \"the first woman and the next man\" on the Moon, specifically at the lunar south pole region by 2024.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "2017-12-11T00:00:00Z",
                        "end_date": null,
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1798,
                    "name": "Orion abort test booster",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/orion2520abort2520test2520booster_image_20190701191116.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193808.jpeg",
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
                "info_url": "https://www.nasa.gov/sites/default/files/atoms/files/aa2_fact_sheet.pdf",
                "wiki_url": "https://en.wikipedia.org/wiki/Orion_Abort_Test_Booster",
                "description": "The Orion Abort Test Booster is a small solid rocket launcher developed by Northropp Grumman.\r\n\r\nIt uses a single stage Peacekeeper missile first stage motor [SR118] inside an Aero-Shell to replicate the Orion Service Module 5.5 meter diameter.",
                "alias": "",
                "min_stage": 1,
                "max_stage": 1,
                "length": null,
                "diameter": 5.5,
                "maiden_flight": "2019-07-02",
                "launch_cost": null,
                "launch_mass": null,
                "leo_capacity": null,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 2200.0,
                "apogee": 9.0,
                "total_launch_count": 1,
                "consecutive_successful_launches": 1,
                "successful_launches": 1,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 163,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/163/",
                "name": "Saturn IB",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 138,
                        "name": "Saturn",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1961-10-27",
                        "total_launch_count": 33,
                        "consecutive_successful_launches": 16,
                        "successful_launches": 31,
                        "failed_launches": 2,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Saturn IB",
                "variant": "IB",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 4,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/4/",
                        "name": "Apollo",
                        "image": {
                            "id": 1877,
                            "name": "[AUTO] Apollo - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/apollo_program_20200820200202.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194019.png",
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
                        "info_url": "https://www.nasa.gov/mission_pages/apollo/index.html",
                        "wiki_url": "https://en.wikipedia.org/wiki/Apollo_program",
                        "description": "The Apollo program was the third United States human spaceflight program carried out by the National Aeronautics and Space Administration (NASA), which succeeded in landing the first humans on the Moon from 1969 to 1972.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "1966-11-16T00:00:00Z",
                        "end_date": "1972-12-19T19:24:59Z",
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1819,
                    "name": "[AUTO] Saturn IB - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/saturn2520ib_image_20190222030046.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193844.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Saturn_IB",
                "description": "The Saturn IB (pronounced \"one B\", also known as the Uprated Saturn I) was an American launch vehicle commissioned by the National Aeronautics and Space Administration (NASA) for the Apollo program. It replaced the S-IV second stage of the Saturn I with the much more powerful S-IVB, able to launch a partially fueled Apollo Command/Service Module (CSM) or a fully fueled Lunar Module (LM) into low Earth orbit for early flight tests before the larger Saturn V needed for lunar flight was ready.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 43.2,
                "diameter": 6.61,
                "maiden_flight": "1966-02-26",
                "launch_cost": null,
                "launch_mass": 590.0,
                "leo_capacity": 21000.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 7100.0,
                "apogee": null,
                "total_launch_count": 10,
                "consecutive_successful_launches": 6,
                "successful_launches": 9,
                "failed_launches": 1,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P51DT2H22M15S"
            },
            {
                "response_mode": "detailed",
                "id": 93,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/93/",
                "name": "Saturn V",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 138,
                        "name": "Saturn",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1961-10-27",
                        "total_launch_count": 33,
                        "consecutive_successful_launches": 16,
                        "successful_launches": 31,
                        "failed_launches": 2,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Saturn V",
                "variant": "V",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 4,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/4/",
                        "name": "Apollo",
                        "image": {
                            "id": 1877,
                            "name": "[AUTO] Apollo - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/apollo_program_20200820200202.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194019.png",
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
                        "info_url": "https://www.nasa.gov/mission_pages/apollo/index.html",
                        "wiki_url": "https://en.wikipedia.org/wiki/Apollo_program",
                        "description": "The Apollo program was the third United States human spaceflight program carried out by the National Aeronautics and Space Administration (NASA), which succeeded in landing the first humans on the Moon from 1969 to 1972.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "1966-11-16T00:00:00Z",
                        "end_date": "1972-12-19T19:24:59Z",
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1820,
                    "name": "[AUTO] Saturn V - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/saturn2520v_image_20190222030036.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193845.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Saturn_V",
                "description": "The Saturn V was a human-rated expendable rocket used by NASA between 1967 and 1973. Most notably, the Saturn V took the Apollo program to the Moon. It still remains the world's tallest, heaviest, and most powerful rocket ever brought to operational status and is the only launch vehicle to take humans beyond LEO.",
                "alias": "",
                "min_stage": 3,
                "max_stage": 3,
                "length": 110.6,
                "diameter": 10.1,
                "maiden_flight": "1967-11-09",
                "launch_cost": null,
                "launch_mass": 2970.0,
                "leo_capacity": 140000.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 35100.0,
                "apogee": null,
                "total_launch_count": 13,
                "consecutive_successful_launches": 11,
                "successful_launches": 12,
                "failed_launches": 1,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P58DT20H43M"
            },
            {
                "response_mode": "detailed",
                "id": 185,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/185/",
                "name": "Scout X-1",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 139,
                        "name": "Scout",
                        "manufacturer": [
                            {
                                "response_mode": "normal",
                                "id": 1006,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/1006/",
                                "name": "Vought",
                                "abbrev": "",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
                                },
                                "featured": false,
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
                                "description": "Vought was the name of several related American aerospace firms. These have included, in the past, Lewis and Vought Corporation, Chance Vought, Vought-Sikorsky, LTV Aerospace (part of Ling-Temco-Vought), Vought Aircraft Companies, and Vought Aircraft Industries. The first incarnation of Vought was established by Chance M. Vought and Birdseye Lewis in 1917. In 1928, it was acquired by United Aircraft and Transport Corporation, which a few years later became United Aircraft Corporation; this was the first of many reorganizations and buyouts. During the 1920s and 1930s, Vought Aircraft and Chance Vought specialized in carrier-based aircraft for the United States Navy, by far its biggest customer. Chance Vought produced thousands of planes during World War II, including the F4U Corsair. Vought became independent again in 1954, and was purchased by Ling-Temco-Vought in 1961. The company designed and produced a variety of planes and missiles throughout the Cold War. Vought was sold from LTV and owned in various degrees by the Carlyle Group and Northrop Grumman in the early 1990s. It was then fully bought by Carlyle, renamed Vought Aircraft Industries, with headquarters in Dallas, Texas. In June 2010, the Carlyle Group sold Vought to the Triumph Group.",
                                "administrator": null,
                                "founding_year": 1917,
                                "launchers": "",
                                "spacecraft": "",
                                "parent": null,
                                "image": null,
                                "logo": null,
                                "social_logo": null,
                                "total_launch_count": 0,
                                "consecutive_successful_launches": 0,
                                "successful_launches": 0,
                                "failed_launches": 0,
                                "pending_launches": 0,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": null,
                                "wiki_url": "https://en.wikipedia.org/wiki/Vought",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1960-10-04",
                        "total_launch_count": 109,
                        "consecutive_successful_launches": 25,
                        "successful_launches": 97,
                        "failed_launches": 12,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Scout X-1",
                "variant": "X-1",
                "active": false,
                "is_placeholder": false,
                "program": [],
                "reusable": false,
                "image": {
                    "id": 1821,
                    "name": "[AUTO] Scout X-1 - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/scout2520x-1_image_20190324192636.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193847.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Scout_X-1",
                "description": "Scout X-1 was an American expendable launch system and sounding rocket which was flown seven times between August 1960 and October 1961.",
                "alias": "",
                "min_stage": 4,
                "max_stage": 4,
                "length": 25.0,
                "diameter": 1.01,
                "maiden_flight": "1960-07-02",
                "launch_cost": 8910000,
                "launch_mass": 16.0,
                "leo_capacity": 59.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 471.0,
                "apogee": 185.0,
                "total_launch_count": 6,
                "consecutive_successful_launches": 1,
                "successful_launches": 3,
                "failed_launches": 3,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P54DT23H8M16S"
            },
            {
                "response_mode": "detailed",
                "id": 143,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/143/",
                "name": "Space Launch System (SLS)",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 149,
                        "name": "Space Launch System",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": true,
                        "maiden_flight": "2022-11-16",
                        "total_launch_count": 1,
                        "consecutive_successful_launches": 1,
                        "successful_launches": 1,
                        "failed_launches": 0,
                        "pending_launches": 6,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Space Launch System Block 1",
                "variant": "Block 1",
                "active": true,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 15,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/15/",
                        "name": "Artemis",
                        "image": {
                            "id": 1884,
                            "name": "[AUTO] Artemis - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/artemis_program_20220827100930.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194033.png",
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
                        "info_url": "https://www.nasa.gov/specials/artemis/",
                        "wiki_url": "https://en.wikipedia.org/wiki/Artemis_program",
                        "description": "The Artemis program is a US government-funded crewed spaceflight program that has the goal of landing \"the first woman and the next man\" on the Moon, specifically at the lunar south pole region by 2024.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "2017-12-11T00:00:00Z",
                        "end_date": null,
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1838,
                    "name": "[AUTO] Space Launch System (SLS) - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/space_launch_sy_image_20220331082429.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193913.jpeg",
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
                "info_url": "https://www.nasa.gov/exploration/systems/sls/fs/sls.html",
                "wiki_url": "https://en.wikipedia.org/wiki/Space_Launch_System",
                "description": "The Space Launch System (SLS) is an American Space Shuttle-derived heavy expendable launch vehicle. It is part of NASA's deep space exploration plans including as the main launch vehicle of the Artemis program. SLS follows the cancellation of the Constellation program, and is to replace the retired Space Shuttle.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 111.0,
                "diameter": 8.4,
                "maiden_flight": "2022-11-16",
                "launch_cost": 2000000000,
                "launch_mass": 2628.0,
                "leo_capacity": 95000.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 39000.0,
                "apogee": null,
                "total_launch_count": 1,
                "consecutive_successful_launches": 1,
                "successful_launches": 1,
                "failed_launches": 0,
                "pending_launches": 2,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 205,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/205/",
                "name": "Space Launch System (SLS)",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 149,
                        "name": "Space Launch System",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": true,
                        "maiden_flight": "2022-11-16",
                        "total_launch_count": 1,
                        "consecutive_successful_launches": 1,
                        "successful_launches": 1,
                        "failed_launches": 0,
                        "pending_launches": 6,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Space Launch System Block 1B",
                "variant": "Block 1B",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 15,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/15/",
                        "name": "Artemis",
                        "image": {
                            "id": 1884,
                            "name": "[AUTO] Artemis - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/artemis_program_20220827100930.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194033.png",
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
                        "info_url": "https://www.nasa.gov/specials/artemis/",
                        "wiki_url": "https://en.wikipedia.org/wiki/Artemis_program",
                        "description": "The Artemis program is a US government-funded crewed spaceflight program that has the goal of landing \"the first woman and the next man\" on the Moon, specifically at the lunar south pole region by 2024.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "2017-12-11T00:00:00Z",
                        "end_date": null,
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1837,
                    "name": "[AUTO] Space Launch System (SLS) - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/sls_block_1b_image_20200905100013.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193911.jpeg",
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
                "info_url": "https://www.nasa.gov/exploration/systems/sls/fs/sls.html",
                "wiki_url": "https://en.wikipedia.org/wiki/Space_Launch_System",
                "description": "The Space Launch System (SLS) is an American Space Shuttle-derived heavy expendable launch vehicle. It is part of NASA's deep space exploration plans including as the main launch vehicle of the Artemis program. SLS follows the cancellation of the Constellation program, and is to replace the retired Space Shuttle.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 111.0,
                "diameter": 8.4,
                "maiden_flight": null,
                "launch_cost": 2000000000,
                "launch_mass": 2948.0,
                "leo_capacity": 105000.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 39000.0,
                "apogee": null,
                "total_launch_count": 0,
                "consecutive_successful_launches": 0,
                "successful_launches": 0,
                "failed_launches": 0,
                "pending_launches": 4,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 493,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/493/",
                "name": "Space Shuttle",
                "families": [],
                "full_name": "Space Shuttle",
                "variant": "",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 6,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/6/",
                        "name": "Space Shuttle",
                        "image": {
                            "id": 1886,
                            "name": "[AUTO] Space Shuttle - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/space2520shutt_program_20200820202237.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194036.png",
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
                        "info_url": "https://www.nasa.gov/mission_pages/shuttle/main/index.html",
                        "wiki_url": "https://en.wikipedia.org/wiki/Space_Shuttle_program",
                        "description": "The Space Shuttle program was the fourth human spaceflight program carried out by the National Aeronautics and Space Administration (NASA), which accomplished routine transportation for Earth-to-orbit crew and cargo from 1981 to 2011.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "1981-04-12T12:00:03Z",
                        "end_date": "2011-07-08T15:29:00Z",
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": true,
                "image": {
                    "id": 1840,
                    "name": "[AUTO] Space Shuttle - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/space_shuttle_image_20230422074810.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193916.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Space_Shuttle",
                "description": "The Space Shuttle is a retired, partially reusable low Earth orbital spacecraft system operated from 1981 to 2011 by the U.S. National Aeronautics and Space Administration (NASA) as part of the Space Shuttle program. Its official program name was Space Transportation System (STS). Five complete Space Shuttle orbiter vehicles were built and flown on a total of 135 missions from 1981 to 2011.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 56.1,
                "diameter": 8.0,
                "maiden_flight": "1981-04-12",
                "launch_cost": 450000000,
                "launch_mass": 2030.0,
                "leo_capacity": 27500.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 28200.0,
                "apogee": null,
                "total_launch_count": 135,
                "consecutive_successful_launches": 22,
                "successful_launches": 133,
                "failed_launches": 2,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P15DT18H9M36S"
            },
            {
                "response_mode": "detailed",
                "id": 98,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/98/",
                "name": "Titan II",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 70,
                        "name": "Titan",
                        "manufacturer": [
                            {
                                "response_mode": "normal",
                                "id": 82,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/82/",
                                "name": "Lockheed Martin",
                                "abbrev": "LMT",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
                                },
                                "featured": false,
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
                                "description": "Lockheed Martin's Space Division started in the production of missiles and later ICBM's in the 1950s. Their TITAN missile system was used for 12 Gemini spacecraft and the Voyager probes.  They have worked largely in collaboration with NASA on many of their probes, landers, and spacecraft, and hope to play a key role in NASA's return to the moon in 2024.",
                                "administrator": null,
                                "founding_year": 1953,
                                "launchers": "Titan | Agena",
                                "spacecraft": "Hubble | JUNO | InSight",
                                "parent": null,
                                "image": null,
                                "logo": null,
                                "social_logo": null,
                                "total_launch_count": 80,
                                "consecutive_successful_launches": 38,
                                "successful_launches": 77,
                                "failed_launches": 3,
                                "pending_launches": 0,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.lockheedmartin.com/",
                                "wiki_url": "https://en.wikipedia.org/wiki/Lockheed_Martin",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1964-04-08",
                        "total_launch_count": 220,
                        "consecutive_successful_launches": 18,
                        "successful_launches": 205,
                        "failed_launches": 15,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    },
                    {
                        "response_mode": "detailed",
                        "id": 202,
                        "name": "Titan II",
                        "manufacturer": [
                            {
                                "response_mode": "normal",
                                "id": 1014,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/1014/",
                                "name": "Martin Marietta",
                                "abbrev": "MM",
                                "type": {
                                    "id": 3,
                                    "name": "Commercial"
                                },
                                "featured": false,
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
                                "description": "The Martin Marietta Corporation was an American company founded in 1961 through the merger of Glenn L. Martin Company and American-Marietta Corporation. The combined company became a leader in chemicals, aerospace, and electronics. In 1995, it merged with Lockheed Corporation to form Lockheed Martin.",
                                "administrator": null,
                                "founding_year": 1961,
                                "launchers": "",
                                "spacecraft": "",
                                "parent": null,
                                "image": null,
                                "logo": null,
                                "social_logo": null,
                                "total_launch_count": 4,
                                "consecutive_successful_launches": 4,
                                "successful_launches": 4,
                                "failed_launches": 0,
                                "pending_launches": 0,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 0,
                                "failed_landings_spacecraft": 0,
                                "attempted_landings_spacecraft": 0,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": null,
                                "wiki_url": "https://en.wikipedia.org/wiki/Martin_Marietta",
                                "social_media_links": []
                            }
                        ],
                        "parent": {
                            "response_mode": "normal",
                            "id": 70,
                            "name": "Titan",
                            "manufacturer": [
                                {
                                    "response_mode": "normal",
                                    "id": 82,
                                    "url": "https://ll.thespacedevs.com/2.3.0/agencies/82/",
                                    "name": "Lockheed Martin",
                                    "abbrev": "LMT",
                                    "type": {
                                        "id": 3,
                                        "name": "Commercial"
                                    },
                                    "featured": false,
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
                                    "description": "Lockheed Martin's Space Division started in the production of missiles and later ICBM's in the 1950s. Their TITAN missile system was used for 12 Gemini spacecraft and the Voyager probes.  They have worked largely in collaboration with NASA on many of their probes, landers, and spacecraft, and hope to play a key role in NASA's return to the moon in 2024.",
                                    "administrator": null,
                                    "founding_year": 1953,
                                    "launchers": "Titan | Agena",
                                    "spacecraft": "Hubble | JUNO | InSight",
                                    "parent": null,
                                    "image": null,
                                    "logo": null,
                                    "social_logo": null
                                }
                            ],
                            "parent": null
                        },
                        "description": "",
                        "active": false,
                        "maiden_flight": "1964-04-08",
                        "total_launch_count": 25,
                        "consecutive_successful_launches": 9,
                        "successful_launches": 24,
                        "failed_launches": 1,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Titan II GLV",
                "variant": "GLV",
                "active": false,
                "is_placeholder": false,
                "program": [
                    {
                        "response_mode": "normal",
                        "id": 3,
                        "url": "https://ll.thespacedevs.com/2.3.0/programs/3/",
                        "name": "Gemini",
                        "image": {
                            "id": 1895,
                            "name": "[AUTO] Gemini - image",
                            "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/project2520gem_program_20200820195350.png",
                            "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194053.png",
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
                        "info_url": "https://www.nasa.gov/mission_pages/gemini/index.html",
                        "wiki_url": "https://en.wikipedia.org/wiki/Project_Gemini",
                        "description": "Project Gemini was NASA's second human spaceflight program. Conducted between projects Mercury and Apollo, Gemini started in 1961 and concluded in 1966.",
                        "agencies": [
                            {
                                "response_mode": "list",
                                "id": 44,
                                "url": "https://ll.thespacedevs.com/2.3.0/agencies/44/",
                                "name": "National Aeronautics and Space Administration",
                                "abbrev": "NASA",
                                "type": {
                                    "id": 1,
                                    "name": "Government"
                                }
                            }
                        ],
                        "start_date": "1961-12-07T00:00:00Z",
                        "end_date": "1966-11-15T19:21:04Z",
                        "mission_patches": [],
                        "type": {
                            "id": 2,
                            "name": "Human Spaceflight"
                        }
                    }
                ],
                "reusable": false,
                "image": {
                    "id": 1855,
                    "name": "[AUTO] Titan II - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/titan2520ii_image_20190222030027.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305193940.jpeg",
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
                "info_url": null,
                "wiki_url": "https://en.wikipedia.org/wiki/Titan_II_GLV",
                "description": "The Titan II GLV (Gemini Launch Vehicle) or Gemini-Titan II was an American expendable launch system derived from the Titan II missile, which was used to launch twelve Gemini missions for NASA between 1964 and 1966. Two unmanned launches followed by ten manned ones were conducted from Launch Complex 19 at the Cape Canaveral Air Force Station, starting with Gemini 1 on April 8, 1964.",
                "alias": "",
                "min_stage": 2,
                "max_stage": 2,
                "length": 33.2,
                "diameter": 3.05,
                "maiden_flight": "1964-04-08",
                "launch_cost": null,
                "launch_mass": 154.0,
                "leo_capacity": 3850.0,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 1913.0,
                "apogee": null,
                "total_launch_count": 12,
                "consecutive_successful_launches": 12,
                "successful_launches": 12,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P10DT18H7M23S"
            },
            {
                "response_mode": "detailed",
                "id": 441,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/441/",
                "name": "Trailblazer 1",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 162,
                        "name": "Trailblazer",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1961-04-21",
                        "total_launch_count": 4,
                        "consecutive_successful_launches": 4,
                        "successful_launches": 4,
                        "failed_launches": 0,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Trailblazer 1",
                "variant": "1",
                "active": false,
                "is_placeholder": false,
                "program": [],
                "reusable": false,
                "image": null,
                "info_url": "",
                "wiki_url": null,
                "description": "American test vehicle. The rocket's first three stages would take the upper stage package to a 260 km apogee. The upper stage package was mounted upside-down in relation to the other stages. When it had reached the peak, the three upper stages fired in sequence, ramming the payload, a 13 cm sphere, into the atmosphere at orbital re-entry speeds.",
                "alias": "",
                "min_stage": 4,
                "max_stage": 4,
                "length": 17.1,
                "diameter": 0.58,
                "maiden_flight": "1959-03-03",
                "launch_cost": null,
                "launch_mass": 3.0,
                "leo_capacity": null,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 365.0,
                "apogee": null,
                "total_launch_count": 1,
                "consecutive_successful_launches": 1,
                "successful_launches": 1,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 442,
                "url": "https://ll.thespacedevs.com/2.3.0/launcher_configurations/442/",
                "name": "Trailblazer 2",
                "families": [
                    {
                        "response_mode": "detailed",
                        "id": 162,
                        "name": "Trailblazer",
                        "manufacturer": [
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
                                },
                                "total_launch_count": 141,
                                "consecutive_successful_launches": 11,
                                "successful_launches": 121,
                                "failed_launches": 20,
                                "pending_launches": 6,
                                "consecutive_successful_landings": 0,
                                "successful_landings": 0,
                                "failed_landings": 0,
                                "attempted_landings": 0,
                                "successful_landings_spacecraft": 178,
                                "failed_landings_spacecraft": 2,
                                "attempted_landings_spacecraft": 180,
                                "successful_landings_payload": 0,
                                "failed_landings_payload": 0,
                                "attempted_landings_payload": 0,
                                "info_url": "https://www.nasa.gov",
                                "wiki_url": "https://en.wikipedia.org/wiki/National_Aeronautics_and_Space_Administration",
                                "social_media_links": []
                            }
                        ],
                        "parent": null,
                        "description": "",
                        "active": false,
                        "maiden_flight": "1961-04-21",
                        "total_launch_count": 4,
                        "consecutive_successful_launches": 4,
                        "successful_launches": 4,
                        "failed_launches": 0,
                        "pending_launches": 0,
                        "attempted_landings": 0,
                        "successful_landings": 0,
                        "failed_landings": 0,
                        "consecutive_successful_landings": 0
                    }
                ],
                "full_name": "Trailblazer 2",
                "variant": "2",
                "active": false,
                "is_placeholder": false,
                "program": [],
                "reusable": false,
                "image": null,
                "info_url": "",
                "wiki_url": null,
                "description": "American test vehicle. NASA rocket designed for high-speed re-entry tests.",
                "alias": "",
                "min_stage": 4,
                "max_stage": 4,
                "length": 15.7,
                "diameter": 0.79,
                "maiden_flight": "1961-12-14",
                "launch_cost": null,
                "launch_mass": 6.0,
                "leo_capacity": null,
                "gto_capacity": null,
                "geo_capacity": null,
                "sso_capacity": null,
                "to_thrust": 547.0,
                "apogee": null,
                "total_launch_count": 3,
                "consecutive_successful_launches": 3,
                "successful_launches": 3,
                "failed_launches": 0,
                "pending_launches": 0,
                "attempted_landings": 0,
                "successful_landings": 0,
                "failed_landings": 0,
                "consecutive_successful_landings": 0,
                "fastest_turnaround": "P333DT4H37M"
            }
        ],
        "spacecraft_list": [
            {
                "response_mode": "detailed",
                "id": 43,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/43/",
                "name": "Apollo Lunar Module",
                "type": {
                    "id": 7,
                    "name": "Lander"
                },
                "agency": {
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
                "family": [],
                "in_use": false,
                "image": {
                    "id": 2089,
                    "name": "Lunar Module on the Moon (Apollo 16)",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/lunar_module_on_image_20240505074251.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/lunar_module_on_image_thumbnail_20240505074252.jpeg",
                    "credit": "NASA / Apollo 16 astronauts",
                    "license": {
                        "id": 4,
                        "name": "NASA Image and Media Guidelines",
                        "priority": 0,
                        "link": "https://www.nasa.gov/nasa-brand-center/images-and-media/"
                    },
                    "single_use": true,
                    "variants": []
                },
                "capability": "Landing on the Moon, Rendezvous in lunar orbit",
                "history": "First flown in 1969, the LM achieved its historic moment on July 20th, 1969, when the \"Eagle\" landed on the Moon, carrying the first humans to walk on its surface.",
                "details": "The Apollo Lunar Module was the lunar lander spacecraft that was flown between lunar orbit and the Moon's surface during the United States' Apollo program. It was the first crewed spacecraft to operate exclusively in the airless vacuum of space, and was the first crewed vehicle to land anywhere beyond Earth.",
                "maiden_flight": "1968-01-22",
                "height": 7.04,
                "diameter": 4.22,
                "human_rated": true,
                "crew_capacity": 2,
                "payload_capacity": null,
                "payload_return_capacity": null,
                "flight_life": "",
                "wiki_link": "https://en.wikipedia.org/wiki/Apollo_Lunar_Module",
                "info_link": "",
                "spacecraft_flown": 10,
                "total_launch_count": 16,
                "successful_launches": 16,
                "failed_launches": 0,
                "attempted_landings": 6,
                "successful_landings": 6,
                "failed_landings": 0,
                "fastest_turnaround": "PT21H36M20S"
            },
            {
                "response_mode": "detailed",
                "id": 12,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/12/",
                "name": "Gemini",
                "type": {
                    "id": 2,
                    "name": "Capsule"
                },
                "agency": {
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
                "family": [],
                "in_use": false,
                "image": {
                    "id": 1915,
                    "name": "[AUTO] Gemini - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/gemini_image_20190207032517.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194127.jpeg",
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
                "capability": "Human transportation to low Earth orbit.",
                "history": "The Gemini crew capsule (referred to as the Reentry Module) was essentially an enlarged version of the Mercury capsule. Unlike Mercury, the retrorockets, electrical power, propulsion systems, oxygen, and water were located in a detachable Adapter Module behind the Reentry Module. A major design improvement in Gemini was to locate all internal spacecraft systems in modular components, which could be independently tested and replaced when necessary, without removing or disturbing other already tested components.",
                "details": "The spacecraft was 18 feet 5 inches (5.61 m) long and 10 feet (3.0 m) wide, with a launch weight varying from 7,100 to 8,350 pounds (3,220 to 3,790 kg).",
                "maiden_flight": "1964-04-08",
                "height": 5.61,
                "diameter": 3.0,
                "human_rated": true,
                "crew_capacity": 2,
                "payload_capacity": null,
                "payload_return_capacity": null,
                "flight_life": "Between a few hours and multiple days (14 day is the maximum achieved).",
                "wiki_link": "https://en.wikipedia.org/wiki/Project_Gemini#Spacecraft",
                "info_link": "",
                "spacecraft_flown": 12,
                "total_launch_count": 12,
                "successful_launches": 12,
                "failed_launches": 0,
                "attempted_landings": 11,
                "successful_landings": 11,
                "failed_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 11,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/11/",
                "name": "Mercury",
                "type": {
                    "id": 2,
                    "name": "Capsule"
                },
                "agency": {
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
                "family": [],
                "in_use": false,
                "image": {
                    "id": 1917,
                    "name": "[AUTO] Mercury - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/mercury_image_20190207032519.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194131.jpeg",
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
                "capability": "Human transportation to upper Earth atmosphere and low Earth orbit.",
                "history": "The Mercury spacecraft was the manned capsule used for suborbital and orbital launches during the Project Mercury, the first human spaceflight program of the United States, from 1958 through 1963.",
                "details": "The Mercury spacecraft's principal designer was Maxime Faget, who started research for manned spaceflight during the time of the NACA. With 100 cubic feet (2.8 m3) of habitable volume, the capsule was just large enough for a single crew member. Inside were 120 controls: 55 electrical switches, 30 fuses and 35 mechanical levers. The heaviest spacecraft, Mercury-Atlas 9, weighed 3,000 pounds (1,400 kg) fully loaded. Its outer skin was made of René 41, a nickel alloy able to withstand high temperatures.",
                "maiden_flight": "1961-05-05",
                "height": 3.3,
                "diameter": 1.8,
                "human_rated": true,
                "crew_capacity": 1,
                "payload_capacity": null,
                "payload_return_capacity": null,
                "flight_life": "Between 15 minutes and 3 days.",
                "wiki_link": "https://en.wikipedia.org/wiki/Project_Mercury#Spacecraft",
                "info_link": "",
                "spacecraft_flown": 14,
                "total_launch_count": 17,
                "successful_launches": 12,
                "failed_launches": 5,
                "attempted_landings": 15,
                "successful_landings": 14,
                "failed_landings": 1,
                "fastest_turnaround": "P28DT2H15M"
            },
            {
                "response_mode": "detailed",
                "id": 13,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/13/",
                "name": "North American X-15",
                "type": {
                    "id": 3,
                    "name": "Spaceplane"
                },
                "agency": {
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
                "family": [],
                "in_use": false,
                "image": {
                    "id": 1918,
                    "name": "[AUTO] North American X-15 - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/north2520american2520x-15_image_20190207032520.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194132.jpeg",
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
                "capability": "Experimental aircraft used for Aircraft and Spacecraft design",
                "history": "The North American X-15 currently holds the record for the highest speed in a manned, powered aircraft.\r\n\r\nThe three variants of the X-15 flew nearly 200 times, with 13 of them going over 80km high.",
                "details": "The North American X-15 was a hypersonic rocket-powered aircraft operated by the United States Air Force and the National Aeronautics and Space Administration. The X-15 reached altitudes of over 80km and speeds of over 6000 km/h.\r\n\r\nThe X-15 had a wingspan of 6.8 meters, and length of 15.4",
                "maiden_flight": "1959-06-08",
                "height": 15.45,
                "diameter": 6.8,
                "human_rated": true,
                "crew_capacity": 1,
                "payload_capacity": null,
                "payload_return_capacity": null,
                "flight_life": "~10 minute flights",
                "wiki_link": "https://en.wikipedia.org/wiki/North_American_X-15",
                "info_link": "https://airandspace.si.edu/collection-objects/north-american-x-15",
                "spacecraft_flown": 2,
                "total_launch_count": 13,
                "successful_launches": 12,
                "failed_launches": 1,
                "attempted_landings": 12,
                "successful_landings": 12,
                "failed_landings": 0,
                "fastest_turnaround": "P22DT14M5S"
            },
            {
                "response_mode": "detailed",
                "id": 4,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/4/",
                "name": "Orion",
                "type": {
                    "id": 2,
                    "name": "Capsule"
                },
                "agency": {
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
                "family": [],
                "in_use": true,
                "image": {
                    "id": 1919,
                    "name": "Orion approaching the Moon (Artemis I)",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/orion_image_20231118102035.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194133.jpeg",
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
                "capability": "Lunar Missions.",
                "history": "The Orion Multi-Purpose Crew Vehicle (Orion MPCV) is an American spacecraft intended to carry a crew of four astronauts to destinations at or beyond low Earth orbit (LEO). Currently under development by NASA for launch on the Space Launch System, Orion is intended to facilitate human exploration of asteroids and of Mars, as well as to provide a means of delivering or retrieving crew or supplies from the ISS if needed.",
                "details": "The Orion MPCV takes basic design elements from the Apollo Command Module that took astronauts to the moon, but its technology and capability are more advanced. It is designed to support long-duration deep space missions, with up to 21 days active crew time plus 6 months quiescent. During the quiescent period crew life support would be provided by another module such as a Deep Space Habitat. The spacecraft's life support, propulsion, thermal protection and avionics systems are designed to be upgradeable as new technologies become available. nn The MPCV spacecraft includes both crew and service modules, and a spacecraft adaptor. The MPCV's crew module is larger than Apollo's and can support more crew members for short or long-duration missions. The service module fuels and propels the spacecraft as well as storing oxygen and water for astronauts. The service module's structure is also being designed to provide locations to mount scientific experiments and cargo.",
                "maiden_flight": "2022-11-16",
                "height": 3.3,
                "diameter": 5.03,
                "human_rated": true,
                "crew_capacity": 4,
                "payload_capacity": 100,
                "payload_return_capacity": null,
                "flight_life": "21.1 days",
                "wiki_link": "https://en.wikipedia.org/wiki/Orion_(spacecraft)",
                "info_link": "",
                "spacecraft_flown": 2,
                "total_launch_count": 2,
                "successful_launches": 2,
                "failed_launches": 0,
                "attempted_landings": 2,
                "successful_landings": 2,
                "failed_landings": 0,
                "fastest_turnaround": null
            },
            {
                "response_mode": "detailed",
                "id": 14,
                "url": "https://ll.thespacedevs.com/2.3.0/spacecraft_configurations/14/",
                "name": "Space Shuttle",
                "type": {
                    "id": 3,
                    "name": "Spaceplane"
                },
                "agency": {
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
                "family": [],
                "in_use": false,
                "image": {
                    "id": 1934,
                    "name": "[AUTO] Space Shuttle - image",
                    "image_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/space2520shuttle_image_20190207032524.jpeg",
                    "thumbnail_url": "https://thespacedevs-prod.nyc3.digitaloceanspaces.com/media/images/255bauto255d__image_thumbnail_20240305194159.jpeg",
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
                "capability": "Carrying a crew of 7 astronauts along with cargo to Low Earth Orbit.",
                "history": "The Space shuttle was a United States space craft. Following the conclusion of the Apollo program the Space Shuttle intended to lower costs for reliable access to Low Earth Orbit. The program ran from 1981-2011.",
                "details": "The Space Shuttle was a partially reusable LEO spacecraft system operated by the U.S. National Aeronautics and Space Administration (NASA) as part of the Space Shuttle program. Its official program name was Space Transportation System (STS), taken from a 1969 plan for a system of reusable spacecraft of which it was the only item funded for development. The first of four orbital test flights occurred in 1981, leading to operational flights in 1982. In addition to the prototype whose completion was cancelled, five complete Shuttle systems were built and used on a total of 135 missions from 1981 to 2011, launched from the Kennedy Space Center (KSC) in Florida. Operational missions launched numerous satellites, interplanetary probes, and the Hubble Space Telescope (HST); conducted science experiments in orbit; and participated in construction and servicing of the International Space Station. The Shuttle fleet's total mission time was 1322 days, 19 hours, 21 minutes and 23 seconds.",
                "maiden_flight": "1981-04-12",
                "height": 56.1,
                "diameter": 8.7,
                "human_rated": true,
                "crew_capacity": 7,
                "payload_capacity": 27500,
                "payload_return_capacity": null,
                "flight_life": "14 days",
                "wiki_link": "https://en.wikipedia.org/wiki/Space_Shuttle",
                "info_link": "",
                "spacecraft_flown": 5,
                "total_launch_count": 135,
                "successful_launches": 133,
                "failed_launches": 2,
                "attempted_landings": 134,
                "successful_landings": 133,
                "failed_landings": 1,
                "fastest_turnaround": "P50DT7H29M"
            }
        ]
    }
""".trimIndent()
