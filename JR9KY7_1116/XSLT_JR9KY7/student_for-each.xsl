<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		
		<html>
			<body>
				<h2>Fekete Mate - for-each, value-of</h2>
				
				<table border = "4">
					<tr bgcolor = "#9acd32">
						<th>ID</th>
						<th>Vezeteknev</th>
						<th>Keresztnev</th>
						<th>Becenev</th>
						<th>Kor</th>
						<th>Osztondij</th>
					</tr>
					
					<xsl:for-each select = "class/student">
						<tr>
							<td>
								<!-- Akar gondolom több is mehetne ide -->
								<xsl:value-of select="@id"></xsl:value-of>
							</td>
							
							<td><xsl:value-of select="vezeteknev"></xsl:value-of></td>
							<td><xsl:value-of select="keresztnev"></xsl:value-of></td>
							<td><xsl:value-of select="becenev"></xsl:value-of></td>
							<td><xsl:value-of select="kor"></xsl:value-of></td>
							<td><xsl:value-of select="osztondij"></xsl:value-of></td>
						</tr>
					</xsl:for-each>>
					
				</table>
			</body>
		</html>
		
	</xsl:template>
</xsl:stylesheet>