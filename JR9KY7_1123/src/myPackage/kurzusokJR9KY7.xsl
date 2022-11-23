<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">

        <html>
            <body>
                <h2>JR9KY7 kurzusok</h2>

                <table border = "4">
                    <tr bgcolor = "#9acd32">
                        <th>Kurzus</th>
                        <th>Helyszin</th>
                        <th>Nap</th>
                        <th>Tol</th>
                        <th>Ig</th>
                        <th>Oktato</th>
                        <th>Jegy</th>
                    </tr>

                    <xsl:for-each select = "root/vizsgak_JR9KY7/vizsga">
                        <tr>
                            <td><xsl:value-of select="kurzus"></xsl:value-of></td>
                            <td><xsl:value-of select="helyszin"></xsl:value-of></td>
                            <td><xsl:value-of select="idopont/nap"></xsl:value-of></td>
                            <td><xsl:value-of select="idopont/tol"></xsl:value-of></td>
                            <td><xsl:value-of select="idopont/ig"></xsl:value-of></td>
                            <td><xsl:value-of select="oktato"></xsl:value-of></td>
                            <td><xsl:value-of select="jegy"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>>

                    <tr>
                        <th>Jegyek atlaga:</th>
                        <th></th>
                    </tr>

                </table>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>