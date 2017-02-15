

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<t:main_layout title="HomePage">

<jsp:attribute name="page_wrapper">

			
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">ACCUEIL</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Campagnes</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Liste des campagnes</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-edit fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>Formulaires</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Liste des questions</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-institution fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">6</div>
                                    <div>Etablissements</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Liste des établissements</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-graduation-cap fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">630</div>
                                    <div>Elèves</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Liste des élèves</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Campagnes
                        </div>
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Campagnes en cours
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Campagne</th>
                                        <th>Etablissement</th>
                                        <th>Date début</th>
                                        <th>Date fin</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>Camp1</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp3</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp4</td>
                                        <td>Etab2</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp6</td>
                                        <td>Etab3</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp7</td>
                                        <td>Etab4</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp1</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp3</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp4</td>
                                        <td>Etab2</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp6</td>
                                        <td>Etab3</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp7</td>
                                        <td>Etab4</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp1</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp3</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp4</td>
                                        <td>Etab2</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp6</td>
                                        <td>Etab3</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp7</td>
                                        <td>Etab4</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp1</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp3</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp4</td>
                                        <td>Etab2</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp6</td>
                                        <td>Etab3</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp7</td>
                                        <td>Etab4</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp1</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp3</td>
                                        <td>Etab1</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp4</td>
                                        <td>Etab2</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp6</td>
                                        <td>Etab3</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                    <tr class="odd gradeX">
                                        <td>Camp7</td>
                                        <td>Etab4</td>
                                        <td>01/01/2017</td>
                                        <td>31/01/2017</td>
                                    </tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
</jsp:attribute>
 
</t:main_layout>