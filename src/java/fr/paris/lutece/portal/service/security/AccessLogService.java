/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.portal.service.security;

import fr.paris.lutece.portal.service.spring.SpringContextService;
import java.util.List;

/**
 * This class provides writing services in the application logs files
 */
public final class AccessLogService
{

    public static final String BEAN_ACCESS_LOGGER = "accessLogger";

    private List<IAccessLogger> _accessLoggerList;
    private static AccessLogService _singleton = new AccessLogService( );

    /**
     * Creates a new AppLogService object.
     */
    private AccessLogService( )
    {
        _accessLoggerList = SpringContextService.getBeansOfType( IAccessLogger.class );
    }

    /**
     * Get the unique instance of the Service
     * 
     * @return The instance
     */
    public static AccessLogService getInstance( )
    {
        return _singleton;
    }

    /**
     * Log action with info level
     * 
     * @param strEventType
     * @param strAppEventCode
     * @param strConnectedUserLogin
     * @param data
     */
    public void info( String strEventType, String strAppEventCode, String strConnectedUserLogin, Object data )
    {
        for ( IAccessLogger accessLogger : _accessLoggerList ) 
        {
            accessLogger.info( strEventType, strAppEventCode, strConnectedUserLogin, data );
        }
    }

    /**
     * Log action with Debug level
     * 
     * @param strEventType
     * @param strAppEventCode
     * @param strConnectedUserLogin
     * @param data
     */
    public void debug( String strEventType, String strAppEventCode, String strConnectedUserLogin, Object data )
    {
        for ( IAccessLogger accessLogger : _accessLoggerList ) 
        {
            accessLogger.debug( strEventType, strAppEventCode, strConnectedUserLogin, data );
        }
    }

    /**
     * Log action with trace level
     * 
     * @param strEventType
     * @param strAppEventCode
     * @param strConnectedUserLogin
     * @param data
     */
    public void trace( String strEventType, String strAppEventCode, String strConnectedUserLogin, Object data )
    {
        for ( IAccessLogger accessLogger : _accessLoggerList ) 
        {
            accessLogger.trace( strEventType, strAppEventCode, strConnectedUserLogin, data );
        }
    }

}
