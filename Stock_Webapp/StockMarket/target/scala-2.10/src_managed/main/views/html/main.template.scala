
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">

        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
        
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.54*/routes/*12.60*/.Assets.at("stylesheets/jquery.dataTables.css"))),format.raw/*12.107*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.54*/routes/*13.60*/.Assets.at("stylesheets/main.css"))),format.raw/*13.94*/("""">
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*14.39*/routes/*14.45*/.Assets.at("javascripts/amcharts/style.css"))),format.raw/*14.89*/("""" type="text/css">
        
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*18.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("javascripts/jquery.dataTables.min.js"))),format.raw/*19.79*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("javascripts/amcharts/amcharts.js"))),format.raw/*20.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*21.23*/routes/*21.29*/.Assets.at("javascripts/amcharts/serial.js"))),format.raw/*21.73*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*22.23*/routes/*22.29*/.Assets.at("javascripts/amcharts/amstock.js"))),format.raw/*22.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*23.23*/routes/*23.29*/.Assets.at("javascripts/chartgen.js"))),format.raw/*23.66*/("""" type="text/javascript"><</script>
    </head>
    <body>
    	"""),_display_(Seq[Any](/*26.7*/content)),format.raw/*26.14*/("""
    	"""),_display_(Seq[Any](/*27.7*/chart)),format.raw/*27.12*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 21 11:22:31 CEST 2014
                    SOURCE: C:/Users/Arnoud/Stock-Market-2.0/play-reactive-mongo/app/views/main.scala.html
                    HASH: ed989718b70faefb80f69b5302dc2f70b03f29f2
                    MATRIX: 560->1|684->31|772->84|798->89|895->151|909->157|964->191|1186->377|1201->383|1271->430|1363->486|1378->492|1434->526|1511->567|1526->573|1592->617|1787->776|1802->782|1869->827|1962->884|1977->890|2049->940|2142->997|2157->1003|2225->1049|2318->1106|2333->1112|2399->1156|2492->1213|2507->1219|2574->1264|2667->1321|2682->1327|2741->1364|2841->1429|2870->1436|2912->1443|2939->1448
                    LINES: 19->1|22->1|28->7|28->7|29->8|29->8|29->8|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|47->26|47->26|48->27|48->27
                    -- GENERATED --
                */
            