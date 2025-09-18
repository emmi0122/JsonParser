package se.berg.service;

import se.berg.domain.TestSequence;

public class HtmlReportGenerator {
    public static void generateReport(TestSequence sequence, String fileName) {
        StringBuilder html = new StringBuilder();

        //HTML structure that looks like an IPV-document
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"en\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Factory Acceptance and IPV Test Report</title>\n");
        html.append("    <style>\n");
        html.append(getCSS());
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");

        //Header section that looks like an IPV-document
        html.append(generateHeader());

        // Test sekvens namn
        html.append("    <div class=\"main-content\">\n");
        html.append("        <h1>FACTORY ACCEPTANCE AND IPV TEST FOR BERG® MPC800M</h1>\n");
        html.append("        <h2>[Vessel Type]</h2>\n");
        html.append("        <h2>[System Description]</h2>\n");

        //Project information (can be extended)
        html.append(generateProjectInfo());
    }

    private static String getCSS() {
        return """
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                line-height: 1.4;
                color: #333;
            }

            .header-table td {
                border: 2px solid black;
                padding: 8px;
            }

            .header-table .empty-td {
                padding: 15px;
            }

            .main-content h1 {
                margin: 20px 0;
            }

            .main-content h2 {
                margin: 15px 0;
            }

            .vessel {
                margin-bottom: 3em;
            }

            .project-info p {
                padding: 5px;
            }

            .project-info .label {
                font-weight: bold;
                padding-bottom: 2em;
            }
        """;
    }

    private static String generateHeader() {
        return """
            <table class="header-table">
                <tr>
                    <td style="width: 25%;"><strong>Order No</strong></td>
                    <td style="width: 25%;"><strong>Shipyard</strong></td>
                    <td style="width: 25%;"><strong>Date</strong></td>
                </tr>
                <tr>
                    <td class="empty-td">&nbsp;</td>
                    <td class="empty-td">&nbsp;</td>
                    <td class="empty-td">&nbsp;</td>
                </tr>
                <tr>
                    <td><strong>Location</strong></td>
                    <td><strong>New Build No</strong></td>
                    <td><strong>Class</strong></td>
                </tr>
                <tr>
                    <td class="empty-td">&nbsp;</td>
                    <td class="empty-td">&nbsp;</td>
                    <td class="empty-td">&nbsp;</td>
                </tr>
                <tr>
                    <td><strong>BERG Technician Signature</strong></td>
                    <td colspan="2"><strong>Class Surveyor's Stamp and Signature</strong></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2" class="empty-td">&nbsp;</td>
                </tr>
            </table>
        """;
    }

    private static String generateProjectInfo() {
        return """
            <div class="project-info">
                <div class="label">
                    <p>Designer:</p>
                    <p>Shipyard:</p>
                    <p>Vessel Type:</p>
                    <p>Yard No/Reference:</p>
                </div>
                <div class="label">
                    <p>Berg Project Number:</p>
                    <p>Berg Order Number:</p>
                </div>
            </div>
        """;
    }
}
