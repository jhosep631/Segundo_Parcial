<%
    String opcion = request.getParameter("opcion");

%>


            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("participantes") ? "active" : "") %>" href="ParticipanteControlador">Participantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("seminarios") ? "active" : "") %>" href="SeminarioControlador">Seminarios</a>
                </li>
            </ul>
