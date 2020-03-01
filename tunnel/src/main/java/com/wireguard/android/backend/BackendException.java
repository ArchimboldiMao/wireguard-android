/*
 * Copyright © 2020 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.backend;

import androidx.annotation.Nullable;

public class BackendException extends Exception {
    private static final Object[] FORMAT_ARGS = new Object[0];
    private final Reason reason;
    private final Object[] formatArgs;

    public BackendException(final Reason reason, @Nullable final Throwable cause) {
        super(cause);
        this.reason = reason;
        formatArgs = FORMAT_ARGS;
    }

    public BackendException(final Reason reason) {
        super((Throwable) null);
        this.reason = reason;
        formatArgs = FORMAT_ARGS;
    }

    public BackendException(final Reason reason, final Object... formatArgs) {
        this.reason = reason;
        this.formatArgs = formatArgs;
    }

    public Reason getReason() {
        return reason;
    }

    public Object[] getFormatArgs() {
        return formatArgs;
    }

    public enum Reason {
        MODULE_VERSION_ERROR,
        MULTIPLE_TUNNELS,
        NO_CONFIG,
        TUN_CREATE_ERROR,
        TUNNEL_CONFIG_ERROR,
        TUNNEL_ON_ERROR,
        VPN_NOT_AUTHORIZED,
        VPN_START_ERROR
    }
}
